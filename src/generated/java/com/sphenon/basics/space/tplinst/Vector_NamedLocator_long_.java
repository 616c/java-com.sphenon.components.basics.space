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
@UIClassifier("Vector_NamedLocator_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_NamedLocator_long_
  extends ReadOnlyVector_NamedLocator_long_,
          WriteVector_NamedLocator_long_
          , GenericVector<NamedLocator>
          , GenericIterable<NamedLocator>
{
    public NamedLocator                                    get             (CallContext context, long index) throws DoesNotExist;
    public NamedLocator                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_NamedLocator_long_ReadOnlyVector_NamedLocator_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_NamedLocator_long_ReadOnlyVector_NamedLocator_long__  tryGetReference (CallContext context, long index);

    public NamedLocator                                    set             (CallContext context, long index, NamedLocator item);
    public void                                        add             (CallContext context, long index, NamedLocator item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, NamedLocator item);
    public void                                        append          (CallContext context, NamedLocator item);
    public void                                        insertBefore    (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public NamedLocator                                    replace         (CallContext context, long index, NamedLocator item) throws DoesNotExist;
    public NamedLocator                                    unset           (CallContext context, long index);
    public NamedLocator                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_NamedLocator_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<NamedLocator>              getIterator_NamedLocator_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_NamedLocator_long_          getIterable_NamedLocator_ (CallContext context);
    public Iterable<NamedLocator> getIterable (CallContext context);
}
