// instantiated with jti.pl from Optional
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
import com.sphenon.ui.core.*;
import com.sphenon.ui.annotations.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.services.*;
import com.sphenon.basics.space.*;
import com.sphenon.basics.locating.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.exception.*;

public class Optional_Space_ implements Dumpable {

    protected Space value;

    public Optional_Space_ (CallContext context) {
        this.value = null;
    }

    public Optional_Space_ (CallContext context, Space value) {
        this.value = value;
    }

    public Space getValue (CallContext context) {
        return this.value;
    }

    public void setValue (CallContext context, Space value) {
        this.value = value;
    }

    public String toString() {
        return (this.value == null ? "---" : this.value.toString());
    }

    public void dump(CallContext context, DumpNode dump_node) {
        if (((Object)this.value) instanceof Dumpable) {
            ((Dumpable)((Object)this.value)).dump(context, dump_node);
        } else {
            dump_node.dump(context, this.value.toString());
        }
    }
}
