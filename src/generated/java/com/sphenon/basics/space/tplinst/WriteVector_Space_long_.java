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

public interface WriteVector_Space_long_
{
    public Space set          (CallContext context, long index, Space item);
    public void     add          (CallContext context, long index, Space item) throws AlreadyExists;
    public void     prepend      (CallContext context, Space item);
    public void     append       (CallContext context, Space item);
    public void     insertBefore (CallContext context, long index, Space item) throws DoesNotExist;
    public void     insertBehind (CallContext context, long index, Space item) throws DoesNotExist;
    public Space replace      (CallContext context, long index, Space item) throws DoesNotExist;
    public Space unset        (CallContext context, long index);
    public Space remove       (CallContext context, long index) throws DoesNotExist;
}

