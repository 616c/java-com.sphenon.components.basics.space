// instantiated with jti.pl from ReferenceToMember
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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.reference.*;
import com.sphenon.basics.many.*;

public interface ReferenceToMember_NamedLocator_long_ReadOnlyVector_NamedLocator_long__
  extends Reference_NamedLocator_
    , ReferenceToMember<NamedLocator,ReadOnlyVector<NamedLocator>>
{
    public ReadOnlyVector_NamedLocator_long_ getContainer(CallContext context);
    public long     getIndex    (CallContext context);
}