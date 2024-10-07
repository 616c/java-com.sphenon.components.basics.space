// instantiated with jti.pl from Factory
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
import com.sphenon.basics.locating.*;

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
public interface Factory_SpaceOnDemand_ {

    public SpaceOnDemand mustCreate (CallContext context);

}
