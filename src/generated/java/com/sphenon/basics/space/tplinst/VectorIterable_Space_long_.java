// instantiated with jti.pl from VectorIterable
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

public class VectorIterable_Space_long_ implements Iterable<Space>
{
    protected java.util.Iterator<Space> iterator;

    public VectorIterable_Space_long_ (CallContext context, Vector_Space_long_ vector) {
        this.iterator = (vector == null ? (new java.util.Vector<Space>()).iterator() : vector.getIterator_Space_(context));
    }

    public java.util.Iterator<Space> iterator () {
        return this.iterator;
    }
}

