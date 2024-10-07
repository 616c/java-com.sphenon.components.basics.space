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
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.data.*;

public class SpaceContext extends SpecificContext {

    static public SpaceContext getOrCreate(Context context) {
        SpaceContext space_context = (SpaceContext) context.getSpecificContext(SpaceContext.class);
        if (space_context == null) {
            space_context = new SpaceContext(context);
            context.setSpecificContext(SpaceContext.class, space_context);
        }
        return space_context;
    }

    static public SpaceContext get(Context context) {
        SpaceContext space_context = (SpaceContext) context.getSpecificContext(SpaceContext.class);
        if (space_context != null) {
            return space_context;
        }
        return null;
    }

    static public SpaceContext create(Context context) {
        SpaceContext space_context = new SpaceContext(context);
        context.setSpecificContext(SpaceContext.class, space_context);
        return space_context;
    }
    
    protected SpaceContext (Context context) {
        super(context);
    }

    protected Space space;

    public void setSpace(CallContext context, Space space) {
        this.space = space;
    }

    public Space getSpace(CallContext cc) {
        SpaceContext space_context;
        Space result;
        return (this.space != null ?
                     this.space
                  : (    (space_context = (SpaceContext) this.getLocationContext(SpaceContext.class)) != null
                      && (result = space_context.getSpace(cc)) != null
                    ) ? result
                  : (    (space_context = (SpaceContext) this.getCallContext(SpaceContext.class)) != null
                      && (result = space_context.getSpace(cc)) != null
                    ) ? result
                  : null
               );
    }

    static protected Space root_space;

    static public void setRootSpace(CallContext context, Space rs) {
        root_space = rs;
    }

    static protected DataSource<Space> root_space_ds;

    static public void setRootSpaceSource(CallContext context, DataSource<Space> rsds) {
        root_space_ds = rsds;
    }

    static public Space getSpaceFromContext(CallContext context) {
        SpaceContext space_context = SpaceContext.get((Context) context);
        Space rs = space_context == null ? null : space_context.getSpace(context);
        return rs != null ? rs : root_space != null ? root_space : root_space_ds != null ? (root_space = root_space_ds.get(context)) : null;
    }

    static public Space findSpaceByPath(CallContext context, String path) {
        Space root = getSpaceFromContext(context);
        if (root == null) { return null; }
        return findSpaceByPath(context, root, path);
    }

    static protected Space findSpaceByPath(CallContext context, Space space, String path) {
        if (path == null || path.isEmpty()) { return space; }
        int pos1 = path.indexOf('/');
        String id = (pos1 == -1 ? path : path.substring(0, pos1));
        int pos2 = id.indexOf('=');
        Space target = null;
        if (pos2 == -1) {
            target = space.tryGetKnownSpaceById(context, id);
            if (target == null) { target = space.tryGetSubSpaceById(context, id); }
            if (target == null) { target = space.tryGetSuperSpaceById(context, id); }
        } else {
            String category = id.substring(0, pos2);
            id = id.substring(pos2+1);
            if (category.equals("knownspace")) { target = space.tryGetKnownSpaceById(context, id); }
            else if (category.equals("subspace")) { target = space.tryGetSubSpaceById(context, id); }
            else if (category.equals("superspace")) { target = space.tryGetSuperSpaceById(context, id); }
            else {
                CustomaryContext.create((Context)context).throwPreConditionViolation(context, "Category '%(category)' in space path is invalid, expected 'knownspace', 'subspace' or 'superspace'", "path", path);
                throw (ExceptionPreConditionViolation) null; // compiler insists
            }
        }
        if (target != null && pos1 != -1) {
            return findSpaceByPath(context, target, path.substring(pos1+1));
        }
        return target;
    }
}
