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

public class VectorImplList_Service_long_
  implements Vector_Service_long_, VectorImplList, Dumpable, ManagedResource {
    protected java.util.List vector;

    protected VectorImplList_Service_long_ (CallContext context) {
        vector = new java.util.ArrayList ();
    }

    static public VectorImplList_Service_long_ create (CallContext context) {
        return new VectorImplList_Service_long_(context);
    }

    protected VectorImplList_Service_long_ (CallContext context, java.util.List vector) {
        this.vector = vector;
    }

    static public VectorImplList_Service_long_ create (CallContext context, java.util.List vector) {
        return new VectorImplList_Service_long_(context, vector);
    }

    public Service get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (Service) vector.get((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public Service tryGet       (CallContext context, long index) {
        if (index < 0 || index >= vector.size()) {
            return null;
        }
        return (Service) vector.get((int) index);
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_Service_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_Service_long_(context, this, index);
    }

    public VectorReferenceToMember_Service_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_Service_long_(context, this, index);
    }

    public Service set          (CallContext context, long index, Service item) {
        while (index > vector.size()) { vector.add(null); }
        if( index == vector.size()) {
            vector.add(item);
            return null;
        } else {
            return (Service) vector.set((int) index, item);
        }
    }

    public void     add          (CallContext context, long index, Service item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        set(context, index, item);
    }

    public void     prepend      (CallContext call_context, Service item) {
        if (vector.size() == 0) {
            vector.add(item);
        } else {
            vector.add(0, item);
        }
    }

    public void     append       (CallContext context, Service item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, Service item) throws DoesNotExist {
        try {
            vector.add((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, Service item) throws DoesNotExist {
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

    public Service replace      (CallContext call_context, long index, Service item) throws DoesNotExist {
        try {
            return (Service) vector.set((int) index, item);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(call_context);
            throw (DoesNotExist) null;
        }
    }

    public Service unset        (CallContext context, long index) {
        try {
            return (Service) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public Service remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (Service) vector.remove((int) index);
        } catch (IndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_Service_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Service_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    // to be used with care
    public java.util.List getImplementationList (CallContext context) {
        return this.vector;
    }

    public java.util.Iterator<Service> getIterator_Service_ (CallContext context) {
        return vector.iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_Service_(context);
    }

    public VectorIterable_Service_long_ getIterable_Service_ (CallContext context) {
        return new VectorIterable_Service_long_(context, this);
    }

    public Iterable<Service> getIterable (CallContext context) {
        return getIterable_Service_ (context);
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
