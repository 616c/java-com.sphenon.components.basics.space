// instantiated with jti.pl from Vector
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

import com.sphenon.ui.annotations.*;

@UIId("")
@UIName("")
@UIClassifier("Vector_Space_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Space_long_
  extends ReadOnlyVector_Space_long_,
          WriteVector_Space_long_
          , GenericVector<Space>
          , GenericIterable<Space>
{
    public Space                                    get             (CallContext context, long index) throws DoesNotExist;
    public Space                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Space_long_ReadOnlyVector_Space_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Space_long_ReadOnlyVector_Space_long__  tryGetReference (CallContext context, long index);

    public Space                                    set             (CallContext context, long index, Space item);
    public void                                        add             (CallContext context, long index, Space item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Space item);
    public void                                        append          (CallContext context, Space item);
    public void                                        insertBefore    (CallContext context, long index, Space item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Space item) throws DoesNotExist;
    public Space                                    replace         (CallContext context, long index, Space item) throws DoesNotExist;
    public Space                                    unset           (CallContext context, long index);
    public Space                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Space_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Space>              getIterator_Space_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Space_long_          getIterable_Space_ (CallContext context);
    public Iterable<Space> getIterable (CallContext context);
}
