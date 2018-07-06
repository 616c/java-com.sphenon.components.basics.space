// instantiated with jti.pl from Factory

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
import com.sphenon.ui.core.*;
import com.sphenon.ui.annotations.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.services.*;
import com.sphenon.basics.space.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.factory.*;
import com.sphenon.basics.factory.returncodes.*;
import com.sphenon.basics.validation.returncodes.*;

/**
  Represents any factory producing a TargetType.

  Since this abstract interface does not know about the
  specific factory attributes, the main purpose is to
  pass already prepared factories to a caller who
  only invokes the actual creation method.

  Furthermore, since this caller has typically no way to
  deal with errors in detail, only the mustCreate method
  is contained in the interface.

  (this thesis has to be evaluated - maybe the create
  and trycreate methods should be added, too)
*/
public interface Factory_Space_ {

    public Space mustCreate (CallContext context);

}
