// instantiated with jti.pl from Reference

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
// please do not modify this file directly
package com.sphenon.basics.space.tplinst;

import com.sphenon.basics.space.*;
import com.sphenon.basics.space.returncodes.*;
import com.sphenon.basics.space.exceptions.*;
import com.sphenon.basics.space.classes.*;
import com.sphenon.basics.space.factories.*;
import com.sphenon.basics.services.*;
import com.sphenon.basics.expression.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.locating.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.metadata.Type;

import com.sphenon.basics.context.*;
import com.sphenon.basics.reference.*;

public interface Reference_Space_
  extends Reference<Space>
{
    public Space get (CallContext context);
}
