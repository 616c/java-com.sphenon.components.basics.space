package com.sphenon.basics.space;

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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.expression.*;

import com.sphenon.basics.expression.returncodes.*;

/* [Issue:LocationRefactoring - space-v2.dia,itlandscapemaintenance.ews,ExpressionEvaluatorServiceLocator_Space.java,ExpressionEvaluatorServiceLocator_RESTService.java,emacsworkspace.el] */
public class ExpressionEvaluatorServiceLocator_Space implements ExpressionEvaluatorServiceLocator {

    public ExpressionEvaluatorServiceLocator_Space(CallContext context) {
    }

    static protected RegularExpression space_locator = new RegularExpression("^(?:(?:oorl:)?//Space/)?([A-Za-z0-9_]+(/[A-Za-z0-9_]+)*)$");

    public ExpressionEvaluatorService findService(CallContext context, String location) throws EvaluationFailure {

        String m[] = space_locator.tryGetMatches(context, location);

        if (m == null || m.length == 0) { return null; }

        String space_path = m[0];

        Space space = SpaceContext.findSpaceByPath(context, space_path);

        if (space == null) {
            EvaluationFailure.createAndThrow(context, "Space '%(space)' not found in context", "space", space_path);
            throw (EvaluationFailure) null;
        }

        ExpressionEvaluatorService ees = space.tryGetServiceByClass(context, ExpressionEvaluatorService.class);

        if (ees == null) {
            EvaluationFailure.createAndThrow(context, "No ExpressionEvaluatorService available at '%(space)'", "space", space_path);
            throw (EvaluationFailure) null;
        }

        return ees;
    }
}
