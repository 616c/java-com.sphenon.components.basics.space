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
@UIClassifier("Vector_DataSource_")
@UIParts("js:instance.getIterable(context)")
public interface Vector_DataSource_long_
  extends ReadOnlyVector_DataSource_long_,
          WriteVector_DataSource_long_
          , GenericVector<DataSource>
          , GenericIterable<DataSource>
{
    public DataSource                                    get             (CallContext context, long index) throws DoesNotExist;
    public DataSource                                    tryGet          (CallContext context, long index);
    public boolean                                     canGet          (CallContext context, long index);

    public ReferenceToMember_DataSource_long_ReadOnlyVector_DataSource_long__  getReference    (CallContext context, long index) throws DoesNotExist;
    public ReferenceToMember_DataSource_long_ReadOnlyVector_DataSource_long__  tryGetReference (CallContext context, long index);

    public DataSource                                    set             (CallContext context, long index, DataSource item);
    public void                                        add             (CallContext context, long index, DataSource item) throws AlreadyExists;
    public void                                        prepend         (CallContext context, DataSource item);
    public void                                        append          (CallContext context, DataSource item);
    public void                                        insertBefore    (CallContext context, long index, DataSource item) throws DoesNotExist;
    public void                                        insertBehind    (CallContext context, long index, DataSource item) throws DoesNotExist;
    public DataSource                                    replace         (CallContext context, long index, DataSource item) throws DoesNotExist;
    public DataSource                                    unset           (CallContext context, long index);
    public DataSource                                    remove          (CallContext context, long index) throws DoesNotExist;

    public IteratorItemIndex_DataSource_long_       getNavigator    (CallContext context);

    public long                                        getSize         (CallContext context);

    // for sake of Iterable's
    public java.util.Iterator<DataSource>              getIterator_DataSource_ (CallContext context);
    public java.util.Iterator                          getIterator (CallContext context);
    public VectorIterable_DataSource_long_          getIterable_DataSource_ (CallContext context);
    public Iterable<DataSource> getIterable (CallContext context);
}
