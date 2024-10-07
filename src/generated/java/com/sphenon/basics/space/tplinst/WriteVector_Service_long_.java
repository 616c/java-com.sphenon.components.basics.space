// instantiated with jti.pl from WriteVector
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

import com.sphenon.basics.many.returncodes.*;

public interface WriteVector_Service_long_
{
    public Service set          (CallContext context, long index, Service item);
    public void     add          (CallContext context, long index, Service item) throws AlreadyExists;
    public void     prepend      (CallContext context, Service item);
    public void     append       (CallContext context, Service item);
    public void     insertBefore (CallContext context, long index, Service item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Service item) throws DoesNotExist;
    public Service replace      (CallContext context, long index, Service item) throws DoesNotExist;
    public Service unset        (CallContext context, long index);
    public Service remove       (CallContext context, long index) throws DoesNotExist;
}

