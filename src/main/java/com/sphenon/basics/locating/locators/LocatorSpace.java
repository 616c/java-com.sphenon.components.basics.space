package com.sphenon.basics.locating.locators;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.space.*;
import com.sphenon.basics.locating.*;
import com.sphenon.basics.locating.returncodes.*;

import com.sphenon.basics.space.*;
import com.sphenon.basics.space.classes.*;

import java.util.Vector;

public class LocatorSpace extends Locator {

    public LocatorSpace (CallContext context, String text_locator_value, Locator sub_locator, String locator_class_parameter_string) {
        super(context, text_locator_value, sub_locator, locator_class_parameter_string);
    }

    /* Parser States -------------------------------------------------------------------- */

    static protected LocatorParserState[] locator_parser_state;
        
    protected LocatorParserState[] getParserStates(CallContext context) {
        if (locator_parser_state == null) {
            locator_parser_state = new LocatorParserState[] {
                new LocatorParserState(context, "space", "space::String:0", false, true, Space.class)
            };
        }
        return locator_parser_state;
    }

    /* Base Acceptors ------------------------------------------------------------------- */

    static protected Vector<LocatorBaseAcceptor> locator_base_acceptors;

    static protected Vector<LocatorBaseAcceptor> initBaseAcceptors(CallContext context) {
        if (locator_base_acceptors == null) {
            locator_base_acceptors = new Vector<LocatorBaseAcceptor>();
            locator_base_acceptors.add(new LocatorBaseAcceptor(context, Space.class));
        }
        return locator_base_acceptors;
    }

    protected Vector<LocatorBaseAcceptor> getBaseAcceptors(CallContext context) {
        return initBaseAcceptors(context);
    }

    static public void addBaseAcceptor(CallContext context, LocatorBaseAcceptor base_acceptor) {
        initBaseAcceptors(context).add(base_acceptor);
    }

    /* ---------------------------------------------------------------------------------- */

    public String doGetTextLocator (CallContext context, Locator relative_to, String result_locator_class) {

        if (relative_to instanceof LocatorSpace) {
            String conf_entry = "com.sphenon.basics.locating.SPACEDEF." + this.getTextLocatorValue(context) + "." + relative_to.getTextLocatorValue(context) + "." + result_locator_class;
            String result_locator = Configuration.get(context, conf_entry, null, (String) null);
            if (result_locator == null) {
                CustomaryContext.create((Context)context).throwConfigurationError(context, "Locator: no property '%(property)' defined", "property", conf_entry);
                throw (ExceptionConfigurationError) null; // compiler insists
            }
            if (this.sub_locator != null && this.sub_locator instanceof LocatorPath) {
                result_locator += concatenate(context, result_locator, this.sub_locator.getTextLocatorValue(context));
            }
            return result_locator;
        }
        
        return super.tryGetTextLocatorValue (context, relative_to, result_locator_class);
    }

    public String tryGetTextLocator (CallContext context, Locator relative_to, String result_locator_class) {

        if (relative_to instanceof LocatorSpace) {
            String conf_entry = "com.sphenon.basics.locating.SPACEDEF." + this.getTextLocatorValue(context) + "." + relative_to.getTextLocatorValue(context) + "." + result_locator_class;
            String result_locator = Configuration.get(context, conf_entry, null, (String) null);
            if (result_locator == null) {
                return null;
            }
            if (this.sub_locator != null && this.sub_locator instanceof LocatorPath) {
                result_locator += concatenate(context, result_locator, this.sub_locator.getTextLocatorValue(context));
            }
            return result_locator;
        }
        
        return super.tryGetTextLocatorValue (context, relative_to, result_locator_class);
    }

    /* ---------------------------------------------------------------------------------- */

    public String getTargetVariableName(CallContext context) {
        return "space";
    }

    protected Object retrieveLocalTarget(CallContext context) throws InvalidLocator {
        Object base = lookupBaseObject(context, false);
        Space space = null;

        if (base == null) {
            space = SpaceContext.getSpaceFromContext(context);
        } else {
            if (base instanceof Space) {
                space = (Space) base;
            } else {
                assert(false);
            }
        }

        LocatorStep[] steps = getLocatorSteps(context);

        for (LocatorStep step : steps) {
            String sv = step.getValue(context);
            if (sv == null || sv.length() == 0) { continue; }
            Space subspace = space.tryGetSubSpaceById(context, sv);
            if (subspace == null) {
                InvalidLocator.createAndThrow(context, "Node in space locator '%(locator)' after step '%(step)' does not exist", "locator", this.getTextLocatorValue(context), "step", step.getValue(context));
                throw (InvalidLocator) null; // compiler insists
             }
            space = subspace;
        }

        return space;
    }
}
