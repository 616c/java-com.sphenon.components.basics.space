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
@UIClassifier("Vector_Service_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_Service_long_
  extends ReadOnlyVector_Service_long_,
          WriteVector_Service_long_
          , GenericVector<Service>
          , GenericIterable<Service>
{
    public Service                                    get             (CallContext context, long index) throws DoesNotExist;
    public Service                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_Service_long_ReadOnlyVector_Service_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_Service_long_ReadOnlyVector_Service_long__  tryGetReference (CallContext context, long index);

    public Service                                    set             (CallContext context, long index, Service item);
    public void                                        add             (CallContext context, long index, Service item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, Service item);
    public void                                        append          (CallContext context, Service item);
    public void                                        insertBefore    (CallContext context, long index, Service item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, Service item) throws DoesNotExist;
    public Service                                    replace         (CallContext context, long index, Service item) throws DoesNotExist;
    public Service                                    unset           (CallContext context, long index);
    public Service                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_Service_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<Service>              getIterator_Service_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_Service_long_          getIterable_Service_ (CallContext context);
    public Iterable<Service> getIterable (CallContext context);
}
