package com.sphenon.basics.space.classes;

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
import com.sphenon.basics.services.*;

import com.sphenon.basics.space.*;
import com.sphenon.basics.space.factories.*;
import com.sphenon.basics.space.tplinst.*;

public class ServicesFromSpace extends DataSourceBase<Vector_Service_long_> {

    public ServicesFromSpace(CallContext context) {
    }

    public void collect(CallContext context, Space space, Vector_Service_long_ services, int level) {
        if (level < this.depth) {
            if (space.getServices(context) != null) {
                for (Service service : space.getServices(context).getIterable(context)) {
                    services.append(context, service);
                }
            }

            if (space.getSubSpaces(context) != null) {
                for (Space sub_space : space.getSubSpaces(context).getIterable(context)) {
                    this.collect(context, sub_space, services, level + 1);
                }
            }
        }
    }

    public Vector_Service_long_ get(CallContext context) {
        Vector_Service_long_ services = Factory_Vector_Service_long_.construct(context);
        this.collect(context, this.space, services, 0);
        return services;
    }

    protected Space space;

    public Space getSpace (CallContext context) {
        return this.space;
    }

    public void setSpace (CallContext context, Space space) {
        this.space = space;
    }

    protected int depth;

    public int getDepth (CallContext context) {
        return this.depth;
    }

    public void setDepth (CallContext context, int depth) {
        this.depth = depth;
    }
}
