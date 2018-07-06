package com.sphenon.basics.space.classes;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.space.*;

import com.sphenon.basics.space.tplinst.*;
import com.sphenon.basics.space.classes.*;
import com.sphenon.basics.space.exceptions.*;
import com.sphenon.basics.space.returncodes.*;
import com.sphenon.basics.space.retrievers.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;
import com.sphenon.basics.event.*;
import com.sphenon.basics.event.tplinst.*;
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.metadata.Type;
import com.sphenon.basics.factory.returncodes.*;
import com.sphenon.basics.retriever.*;
import com.sphenon.basics.validation.*;
import com.sphenon.basics.validation.returncodes.*;
import com.sphenon.basics.validation.validators.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.tplinst.*;
// please include on a per project basis
// import com.sphenon.basics.aspects.*;
import com.sphenon.engines.aggregator.*;


// java
import java.util.List;
import java.io.PrintStream;

// Template: $Id$




import com.sphenon.ui.core.*;
import com.sphenon.ui.annotations.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.services.*;
import com.sphenon.basics.space.*;

// java source generated by Mr.Source from UML (UXF)

public class Class_SpaceOnDemand
  extends Class_Space  implements Validatable, SpaceOnDemand
{
  static final public Class _class = Class_SpaceOnDemand.class;

  static protected long notification_level;
  static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
  static public    long getNotificationLevel() { return notification_level; }

  static protected long runtimestep_level;
  static public    long adjustRuntimeStepLevel(long new_level) { long old_level = runtimestep_level; runtimestep_level = new_level; return old_level; }
  static public    long getRuntimeStepLevel() { return runtimestep_level; }
  static { runtimestep_level = RuntimeStepLocationContext.getLevel(_class); };

  static {
      notification_level = NotificationLocationContext.getLevel(RootContext.getInitialisationContext(), _class);
      SpacePackageInitialiser.initialise(RootContext.getInitialisationContext());
  };

  public Class_SpaceOnDemand (CallContext call_context) {
    super(call_context);
    CallContext context = call_context;
  }
  
  protected boolean is_initialised_class_space_on_demand = false;

  public boolean getIsInitialisedClass_SpaceOnDemand(CallContext context) {
    return this.is_initialised_class_space_on_demand;
  }
  
  public boolean getIsInitialised(CallContext context) {
    return this.is_initialised_class_space_on_demand;
  }
  
  public void initialise(CallContext context) {
      initialiseClass_SpaceOnDemand (context);
  }

  public void initialiseClass_SpaceOnDemand (CallContext call_context) {
    if (!this.is_initialised_class_space_on_demand) {
      this.is_initialised_class_space_on_demand = true;
      CallContext context = call_context;

    }
      initialiseClass_Space( call_context );
    }

  public void destroy (CallContext context) {
    if (!this.is_destroyed) {
      this.is_destroyed = true;
      this.destroyClass_SpaceOnDemand(context);
    }
  }

  public ValidationFailure canDestroy (CallContext context) {
    ValidationFailure vf = super.canDestroy(context);
    if (vf != null) { return vf; }
    return null;
  }

  protected void destroyClass_SpaceOnDemand (CallContext call_context) {
    CallContext context = call_context;
    super.destroyClass_Space(context);
  }
  
  public void finalize () throws Throwable {
    this.destroy(RootContext.getDestructionContext());
    super.finalize();
  }

    public void validateinstanceClass_SpaceOnDemand(CallContext call_context) throws ValidationFailure {
        CallContext context = call_context;
        ValidationFailure vf = validateinstanceClass_SpaceOnDemand(context, null);
        if (vf != null) { throw vf; }
    }
    
    public void validate(CallContext call_context) throws ValidationFailure {
        CallContext context = call_context;
        super.validate(context);
        validateinstanceClass_SpaceOnDemand(context);
    }

    protected ValidationFailure validateinstanceClass_SpaceOnDemand(CallContext call_context, ValidationFailure vf) {
      CallContext context = call_context;
        
        vf = super.validateinstanceClass_Space(context, vf);
        return vf;
    }

  protected volatile boolean sub_space_sources_prepared;
  public Vector_Space_long_ getSubSpaces(CallContext context) {
      Vector_Space_long_ subspaces = super.getSubSpaces(context);
      if (this.sub_space_sources_prepared == false) {
          synchronized(this) {
              if (this.sub_space_sources_prepared == false) {
                  this.sub_space_sources_prepared = true;
                  if (this.getSubSpaceSources(context) != null) {
                      for (DataSource subspacesource : this.getSubSpaceSources(context).getIterable_DataSource_(context)) {
                          Space subspace = (Space) subspacesource.getObject(context);
                          if (subspace != null) {
                              subspaces.append(context, subspace);
                          }
                      }
                  }
              }
          }
      }
      return subspaces;
  }
  protected volatile boolean super_space_sources_prepared;
  public Vector_Space_long_ getSuperSpaces(CallContext context) {
      Vector_Space_long_ superspaces = super.getSuperSpaces(context);
      if (this.super_space_sources_prepared == false) {
          synchronized(this) {
              if (this.super_space_sources_prepared == false) {
                  this.super_space_sources_prepared = true;
                  if (this.getSuperSpaceSources(context) != null) {
                      for (DataSource superspacesource : this.getSuperSpaceSources(context).getIterable_DataSource_(context)) {
                          Space superspace = (Space) superspacesource.getObject(context);
                          if (superspace != null) {
                              superspaces.append(context, superspace);
                          }
                      }
                  }
              }
          }
      }
      return superspaces;
  }
  protected volatile boolean known_space_sources_prepared;
  public Vector_Space_long_ getKnownSpaces(CallContext context) {
      Vector_Space_long_ knownspaces = super.getKnownSpaces(context);
      if (this.known_space_sources_prepared == false) {
          synchronized(this) {
              if (this.known_space_sources_prepared == false) {
                  this.known_space_sources_prepared = true;
                  if (this.getKnownSpaceSources(context) != null) {
                      for (DataSource knownspacesource : this.getKnownSpaceSources(context).getIterable_DataSource_(context)) {
                          Space knownspace = (Space) knownspacesource.getObject(context);
                          if (knownspace != null) {
                              knownspaces.append(context, knownspace);
                          }
                      }
                  }
              }
          }
      }
      return knownspaces;
  }
  

  

}
