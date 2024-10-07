// instantiated with jti.pl from ReadOnlyVector
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

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;

public interface ReadOnlyVector_Service_long_
  extends ReadVector_Service_long_,
          ReadOnlyVector<Service>,
          OfKnownSize
{
    public Service                                    get             (CallContext context, long index) throws DoesNotExist;
    public Service                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Service_long_ReadOnlyVector_Service_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Service_long_ReadOnlyVector_Service_long__  tryGetReference (CallContext context, long index);
}

