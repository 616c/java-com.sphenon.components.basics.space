// instantiated with jti.pl from VectorImpl
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
// import com.sphenon.basics.monitoring.*;
// @review:wm
// zusätzliche includes müssen beim instantiieren angegeben werden,
// sie dürfen nicht direkt ins template eingetragen werden
// anderfalls würde eine dependency von *jeder* instant zu diesem
// package entstehen
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.many.*;

import com.sphenon.basics.many.returncodes.*;

public class VectorImpl_Space_long_
  implements Vector_Space_long_,
             VectorOptimized<Space>,
             Dumpable,
             ManagedResource
 {
    private java.util.Vector vector;

    protected VectorImpl_Space_long_ (CallContext context) {
        vector = new java.util.Vector(4);
    }

    static public VectorImpl_Space_long_ create (CallContext context) {
        return new VectorImpl_Space_long_(context);
    }

    protected VectorImpl_Space_long_ (CallContext context, java.util.Vector vector) {
        this.vector = vector;
    }

    static public VectorImpl_Space_long_ create (CallContext context, java.util.Vector vector) {
        return new VectorImpl_Space_long_(context, vector);
    }

    

    public Space get          (CallContext context, long index) throws DoesNotExist {
        try {
            return (Space) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
    }

    public Space tryGet       (CallContext context, long index) {
        try {
            return (Space) vector.elementAt((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean  canGet       (CallContext context, long index) {
        return (index >= 0 && index < vector.size()) ? true : false;
    }

    public VectorReferenceToMember_Space_long_ getReference    (CallContext context, long index) throws DoesNotExist {
        if ( ! canGet(context, index)) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null; // compiler insists
        }
        return new VectorReferenceToMember_Space_long_(context, this, index);
    }

    public VectorReferenceToMember_Space_long_ tryGetReference (CallContext context, long index) {
        if ( ! canGet(context, index)) { return null; }
        return new VectorReferenceToMember_Space_long_(context, this, index);
    }

    public Space set          (CallContext context, long index, Space item) {
        if (index >= vector.size()) { vector.setSize((int) (index+1)); }
        return (Space) vector.set((int) index, item);
    }

    public void     add          (CallContext context, long index, Space item) throws AlreadyExists {
        if (index < vector.size()) { AlreadyExists.createAndThrow (context); }
        vector.setSize((int) (index+1));
        vector.setElementAt(item, (int) index);
    }

    public void     prepend      (CallContext call_context, Space item) {
        if (vector.size() == 0) {
            vector.add(item);
        } else {
            try {
                vector.insertElementAt(item, 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                Context context = Context.create(call_context);
                CustomaryContext cc = CustomaryContext.create(context);
                cc.throwImpossibleState(context, ManyStringPool.get(context, "0.0.1" /* cannot insert element at position 0, java-lib says 'out of bounds' ??? */));
            }
        }
    }

    public void     append       (CallContext context, Space item) {
        vector.add(item);
    }

    public void     insertBefore (CallContext context, long index, Space item) throws DoesNotExist {
        try {
            vector.insertElementAt(item, (int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(context);
        }
    }

    public void     insertBehind (CallContext context, long index, Space item) throws DoesNotExist {
        if (index == vector.size() - 1) {
            vector.add(item);
        } else {
            try {
                vector.insertElementAt(item, (int) (index+1));
            } catch (ArrayIndexOutOfBoundsException e) {
                DoesNotExist.createAndThrow (context);
            }
        }
    }

    public Space replace      (CallContext call_context, long index, Space item) throws DoesNotExist {
        try {
            return (Space) vector.set((int) index, item);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow(call_context);
            throw (DoesNotExist) null;
        } catch (IllegalArgumentException e) {
            Context context = Context.create(call_context);
            CustomaryContext cc = CustomaryContext.create(context);
            cc.throwImpossibleState (context, ManyStringPool.get(context, "0.0.2" /* An exception occured, with respect to which the java-lib documentation is unfortunately incorrect */));
            throw (ExceptionImpossibleState) null;
        }
    }

    public Space unset        (CallContext context, long index) {
        try {
            return (Space) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // we kindly ignore this exception
            return null;
        }
    }

    public Space remove       (CallContext context, long index) throws DoesNotExist {
        try {
            return (Space) vector.remove((int) index);
        } catch (ArrayIndexOutOfBoundsException e) {
            DoesNotExist.createAndThrow (context);
            throw (DoesNotExist) null;
        }
    }

    public IteratorItemIndex_Space_long_ getNavigator (CallContext context) {
        return new VectorIteratorImpl_Space_long_ (context, this);
    }

    public long     getSize      (CallContext context) {
        return vector.size();
    }

    public java.util.Iterator<Space> getIterator_Space_ (CallContext context) {
        return vector.iterator();
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_Space_(context);
    }

    public VectorIterable_Space_long_ getIterable_Space_ (CallContext context) {
        return new VectorIterable_Space_long_(context, this);
    }

    public Iterable<Space> getIterable (CallContext context) {
        return getIterable_Space_ (context);
    }

    public java.util.Vector getImplementationVector(CallContext context){
      return this.vector;
    }

    public void setImplementationVector(CallContext context, java.util.Vector vector){
      this.vector = vector;
    }

    public boolean contains(CallContext context, Space item) {
        return this.vector.contains(item);
    }

    public boolean removeFirst(CallContext context, Space item) {
        return this.vector.remove(item);
    }

    public void removeAll(CallContext context, Space item, VectorOptimized.Notifier<Space> notifier) {
        java.util.Iterator i = this.vector.iterator();
        while (i.hasNext()) {
            if (i.next() == item) {
                i.remove();
                if (notifier != null) { notifier.onRemove(context, item); }
            }
        }
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
