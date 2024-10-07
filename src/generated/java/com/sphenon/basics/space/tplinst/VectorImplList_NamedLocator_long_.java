// instantiated with jti.pl from VectorImplList
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
import com.sphenon.basics.debug.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorImplList_NamedLocator_long_
  implements Vector_NamedLocator_long_, VectorImplList, Dumpable, ManagedResource {
    protected java.util.List vector;

    protected VectorImplList_NamedLocator_long_ (CallContext context) {
        vector = new java.util.ArrayList ();
    }

    static public VectorImplList_NamedLocator_long_ create (CallContext context) {
        return new VectorImplList_NamedLocator_long_(context);
    }

    protected VectorImplList_NamedLocator_long_ (CallContext context, java.util.List vector) {
        this.vector = vector;
    }

    static public VectorImplList_NamedLocator_long_ create (CallContext context, java.util.List vector) {
        return new VectorImplList_NamedLocator_long_(context, vector);
    }

    public NamedLocator get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (NamedLocator) vector.get((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public NamedLocator tryGet       (CallContext context, long index) {
        if (index < 0 || index >= vector.size()) {
            return null;
        }
        return (NamedLocator) vector.get((int) index);
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_NamedLocator_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_NamedLocator_long_(context, this, index);
    }

    public VectorReferenceToMember_NamedLocator_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_NamedLocator_long_(context, this, index);
    }

    public NamedLocator set          (CallContext context, long index, NamedLocator item) {
        while (index > vector.size()) { vector.add(null); }
        if( index == vector.size()) {
            vector.add(item);
            return null;
        } else {
            return (NamedLocator) vector.set((int) index, item);
        }
    }

    public void     add          (CallContext context, long index, NamedLocator item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        set(context, index, item);
    }

    public void     prepend      (CallContext call_context, NamedLocator item) {
        if (vector.size() == 0) {
            vector.add(item);
        } else {
            vector.add(0, item);
        }
    }

    public void     append       (CallContext context, NamedLocator item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, NamedLocator item) throws DoesNotExist {
        try {
            vector.add((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, NamedLocator item) throws DoesNotExist {
        if (index == vector.size() - 1) {
            vector.add(item);
        } else {
            try {
                vector.add((int) index + 1, item);
            } catch (IndexOutOfBoundsException e) {
                DoesNotExist.createAndThrow (context);
            }
        }
    }

    public NamedLocator replace      (CallContext call_context, long index, NamedLocator item) throws DoesNotExist {
        try {
            return (NamedLocator) vector.set((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(call_context);
            throw (DoesNotExist) null;
        }
    }

    public NamedLocator unset        (CallContext context, long index) {
        try {
            return (NamedLocator) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public NamedLocator remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (NamedLocator) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_NamedLocator_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_NamedLocator_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    // to be used with care
    public java.util.List getImplementationList (CallContext context) {
        return this.vector;
    }

    public java.util.Iterator<NamedLocator> getIterator_NamedLocator_ (CallContext context) {
        return vector.iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_NamedLocator_(context);
    }

    public VectorIterable_NamedLocator_long_ getIterable_NamedLocator_ (CallContext context) {
        return new VectorIterable_NamedLocator_long_(context, this);
    }

    public Iterable<NamedLocator> getIterable (CallContext context) {
        return getIterable_NamedLocator_ (context);
    }


    public void release(CallContext context) {
        if (this.vector != null && this.vector instanceof ManagedResource) {
            ((ManagedResource)(this.vector)).release(context);
        }
    }

    public void dump(CallContext context, DumpNode dump_node) {
        int i=1;
        for (Object o : vector) {
            dump_node.dump(context, (new Integer(i++)).toString(), o);
        }
    }
}
