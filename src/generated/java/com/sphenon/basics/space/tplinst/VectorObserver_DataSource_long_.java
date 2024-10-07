// instantiated with jti.pl from VectorObserver
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
import com.sphenon.basics.customary.*;
import com.sphenon.basics.exception.*;

import com.sphenon.basics.many.*;
import com.sphenon.basics.many.returncodes.*;
import com.sphenon.basics.event.*;
import com.sphenon.basics.event.tplinst.*;

import com.sphenon.ad.adcore.ModificationType;

public class VectorObserver_DataSource_long_
  implements Vector_DataSource_long_,
             Changing,
             Dumpable,
             ManagedResource
{
    protected Vector_DataSource_long_ observed_vector;
    protected boolean need_notification;
    protected VectorObserverEventPolicy event_policy = VectorObserverEventPolicy.ON_DEMAND;

    protected VectorObserverEventPolicy getEventPolicy(CallContext context) {
        return this.event_policy;
    }

    protected void setEventPolicy(CallContext context, VectorObserverEventPolicy event_policy) {
        this.event_policy = event_policy;
    }

    public VectorObserver_DataSource_long_ (CallContext context, Vector_DataSource_long_ observed_vector,VectorObserverEventPolicy event_policy, ModificationType modification_type) {
        this.setEventPolicy(context,event_policy);
        this.observed_vector = observed_vector;
        need_notification = false;
        if (this.observed_vector != null && modification_type != ModificationType.STATE_LOAD) {
            if (getEventPolicy(context) == VectorObserverEventPolicy.ON_DEMAND) {
                need_notification = true;
            } else if (getEventPolicy(context) == VectorObserverEventPolicy.IMMEDIATELY) {
                for (DataSource item : observed_vector.getIterable_DataSource_(context)) {
                    onAdd(context, item);
                }
            }
        }
    }

    public VectorObserver_DataSource_long_ (CallContext context, Vector_DataSource_long_ observed_vector,VectorObserverEventPolicy event_policy) {
        this(context, observed_vector, event_policy, null);
    }

    public VectorObserver_DataSource_long_(CallContext context, Vector_DataSource_long_ observed_vector) {
        this(context, observed_vector, VectorObserverEventPolicy.ON_DEMAND);   
    }

    public void setObserved (CallContext context, Vector_DataSource_long_ observed_vector) {
        if (this.getObserved(context) != null) {
            for (DataSource item : this.observed_vector.getIterable_DataSource_(context)) {
                onRemove(context, item);
            }
        }

        this.observed_vector = observed_vector;

        need_notification = false;
        if (this.observed_vector != null) {
            if (getEventPolicy(context) == VectorObserverEventPolicy.ON_DEMAND || getEventPolicy(context) == VectorObserverEventPolicy.ON_DEMAND_ONLY_EXPLICIT) {
                need_notification = true;
            } else if (getEventPolicy(context) == VectorObserverEventPolicy.IMMEDIATELY || getEventPolicy(context) == VectorObserverEventPolicy.IMMEDIATELY_ONLY_EXPLICIT) {
                for (DataSource item : this.observed_vector.getIterable_DataSource_(context)) {
                    onAdd(context, item);
                }
            }
        }
    }

    public Vector_DataSource_long_ getObserved (CallContext context) {
        if (need_notification && this.observed_vector != null) {
            need_notification = false;
            for (DataSource item : this.observed_vector.getIterable_DataSource_(context)) {
                onAdd(context, item);
            }
        }
        return this.observed_vector;
    }

    // ------------------------------------------------------------------------------------
    // Aspect: Changing
    protected EventDispatcher_ChangeEvent_ change_event_dispatcher = null;
    protected java.util.Date last_update = null;

    protected void notify(CallContext context, ChangeEvent change_event) {
        if (change_event_dispatcher != null) {
            change_event_dispatcher.notify(context, change_event);
        }
        if (this.last_update != null) {
            this.last_update.setTime(System.currentTimeMillis());
        }
    }

    protected void notify(CallContext context) {
        if (change_event_dispatcher != null) {
            change_event_dispatcher.notify(context);
        }
        if (this.last_update != null) {
            this.last_update.setTime(System.currentTimeMillis());
        }
    }

    protected void onAdd(CallContext context, DataSource item) {
    }

    protected void onRemove(CallContext context, DataSource item) {
    }

    public EventDispatcher_ChangeEvent_ getChangeEventDispatcher(CallContext context) {
        if (change_event_dispatcher == null) {
            this.change_event_dispatcher = new EventDispatcher_ChangeEvent_(context);
        }
        return this.change_event_dispatcher;
    }

    public java.util.Date getLastUpdate(CallContext context) {
        if (this.last_update == null) {
            this.last_update = new java.util.Date();
        }
        return this.last_update;
    }
    // ------------------------------------------------------------------------------------

    public DataSource                                    get             (CallContext context, long index) throws DoesNotExist {
        return this.getObserved(context).get(context, index);
    }

    public DataSource                                    tryGet          (CallContext context, long index) {
        return this.getObserved(context).tryGet(context, index);
    }

    public boolean                                     canGet          (CallContext context, long index) {
        return this.getObserved(context).canGet(context, index);
    }

    public ReferenceToMember_DataSource_long_ReadOnlyVector_DataSource_long__ getReference    (CallContext context, long index) throws DoesNotExist {
        return this.getObserved(context).getReference(context, index);
    }

    public ReferenceToMember_DataSource_long_ReadOnlyVector_DataSource_long__ tryGetReference (CallContext context, long index) {
        return this.getObserved(context).tryGetReference(context, index);
    }

    public DataSource                                    set             (CallContext context, long index, DataSource item) {
        DataSource old_item = this.getObserved(context).set(context, index, item);
        if (old_item != null) { 
           onRemove(context, old_item); 
           ChangeEvent event = new RemoveEvent(context,old_item,index);   
           notify(context,event);
        }
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item,index);   
        notify(context,event);
        return old_item;
    }

    public void                                        add             (CallContext context, long index, DataSource item) throws AlreadyExists {
        this.getObserved(context).add(context, index, item);
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item,index);   
        notify(context,event);
    }

    public void                                        prepend         (CallContext context, DataSource item) {
        this.getObserved(context).prepend(context, item);
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item);   
        notify(context,event);
    }

    public void                                        append          (CallContext context, DataSource item) {
        this.getObserved(context).append(context, item);
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item);   
        notify(context,event);
    }

    public void                                        insertBefore    (CallContext context, long index, DataSource item) throws DoesNotExist {
        this.getObserved(context).insertBefore(context, index, item);
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item);   
        notify(context,event);
    }

    public void                                        insertBehind    (CallContext context, long index, DataSource item) throws DoesNotExist {
        this.getObserved(context).insertBehind(context, index, item);
        onAdd(context, item);
        ChangeEvent event = new AddEvent(context,item,index);   
        notify(context,event);
    }

    public DataSource                                    replace         (CallContext context, long index, DataSource item) throws DoesNotExist {
        DataSource old_item = this.getObserved(context).replace(context, index, item);
        onRemove(context, old_item);
        ChangeEvent event = new RemoveEvent(context,old_item,index);   
        notify(context,event);
        onAdd(context, item);
        event = new AddEvent(context,item,index);   
        notify(context,event);
        return old_item;
    }

    public DataSource                                    unset           (CallContext context, long index) {
        DataSource old_item = this.getObserved(context).unset(context, index);
        if (old_item != null) { 
           onRemove(context, old_item); 
           ChangeEvent event = new RemoveEvent(context,old_item,index);   
           notify(context,event);
        }
        return old_item;
    }

    public DataSource                                    remove          (CallContext context, long index) throws DoesNotExist {
        DataSource old_item = this.getObserved(context).remove(context, index);
        onRemove(context, old_item);
        ChangeEvent event = new RemoveEvent(context,old_item,index);   
        notify(context,event);
        return old_item;
    }

    public IteratorItemIndex_DataSource_long_       getNavigator    (CallContext context) {
        return this.getObserved(context).getNavigator(context);
    }

    public long                                        getSize         (CallContext context) {
        return this.getObserved(context).getSize(context);
    }

    public java.util.Iterator<DataSource> getIterator_DataSource_ (CallContext context) {
        return this.getObserved(context).getIterator_DataSource_(context);
    }

    public java.util.Iterator getIterator (CallContext context) {
        return getIterator_DataSource_(context);
    }

    public VectorIterable_DataSource_long_ getIterable_DataSource_ (CallContext context) {
        return new VectorIterable_DataSource_long_(context, this);
    }

    public Iterable<DataSource> getIterable (CallContext context) {
        return getIterable_DataSource_ (context);
    }

    public void release(CallContext context) {
        if (this.observed_vector != null && this.observed_vector instanceof ManagedResource) {
            ((ManagedResource)(this.observed_vector)).release(context);
        }
    }

    public void dump(CallContext context, DumpNode dump_node) {
        if (observed_vector instanceof Dumpable) {
            ((Dumpable)observed_vector).dump(context, dump_node);
        } else {
            dump_node.dump(context, observed_vector.toString());
        }
    }
}

