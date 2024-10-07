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

public interface WriteVector_NamedLocator_long_
{
    public NamedLocator set          (CallContext context, long index, NamedLocator item);
    public void     add          (CallContext context, long index, NamedLocator item) throws AlreadyExists;
    public void     prepend      (CallContext context, NamedLocator item);
    public void     append       (CallContext context, NamedLocator item);
    public void     insertBefore (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public NamedLocator replace      (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public NamedLocator unset        (CallContext context, long index);
    public NamedLocator remove       (CallContext context, long index) throws DoesNotExist;
}

