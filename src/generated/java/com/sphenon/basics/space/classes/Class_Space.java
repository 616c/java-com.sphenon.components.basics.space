package com.sphenon.basics.space.classes;

import com.sphenon.basics.space.*;

import com.sphenon.basics.space.tplinst.*;
import com.sphenon.basics.space.classes.*;
import com.sphenon.basics.space.exceptions.*;
import com.sphenon.basics.space.returncodes.*;
import com.sphenon.basics.space.retrievers.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.debug.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.many.*;
import com.sphenon.basics.many.tplinst.*;
import com.sphenon.basics.event.*;
import com.sphenon.basics.event.tplinst.*;
import com.sphenon.basics.metadata.*;
import com.sphenon.basics.metadata.Type;
import com.sphenon.basics.factory.returncodes.*;
import com.sphenon.basics.retriever.*;
import com.sphenon.basics.validation.*;
import com.sphenon.basics.validation.returncodes.*;
import com.sphenon.basics.validation.validators.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.tplinst.*;
// please include on a per project basis
// import com.sphenon.basics.aspects.*;
import com.sphenon.engines.aggregator.*;


// java
import java.util.List;
import java.io.PrintStream;

// Template: $Id$




import com.sphenon.ui.core.*;
import com.sphenon.ui.annotations.*;
import com.sphenon.basics.data.*;
import com.sphenon.basics.services.*;
import com.sphenon.basics.space.*;
import com.sphenon.basics.locating.*;

// java source generated by Mr.Source from UML (UXF)

public class Class_Space
  implements Validatable, Space
{
  static final public Class _class = Class_Space.class;

  static protected long notification_level;
  static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
  static public    long getNotificationLevel() { return notification_level; }

  static protected long runtimestep_level;
  static public    long adjustRuntimeStepLevel(long new_level) { long old_level = runtimestep_level; runtimestep_level = new_level; return old_level; }
  static public    long getRuntimeStepLevel() { return runtimestep_level; }
  static { runtimestep_level = RuntimeStepLocationContext.getLevel(_class); };

  static {
      notification_level = NotificationLocationContext.getLevel(RootContext.getInitialisationContext(), _class);
      SpacePackageInitialiser.initialise(RootContext.getInitialisationContext());
  };

  public Class_Space (CallContext call_context) {
    CallContext context = call_context;
  }
  
  protected boolean is_initialised_class_space = false;

  public boolean getIsInitialisedClass_Space(CallContext context) {
    return this.is_initialised_class_space;
  }
  
  public boolean getIsInitialised(CallContext context) {
    return this.is_initialised_class_space;
  }
  
  public void initialise(CallContext context) {
      initialiseClass_Space (context);
  }

  public void initialiseClass_Space (CallContext call_context) {
    if (!this.is_initialised_class_space) {
      this.is_initialised_class_space = true;
      CallContext context = call_context;

      {   if (this.super_space_vector_observer == null) {
              this.super_space_vector = null;
              this.super_space_vector = Factory_Vector_Space_long_.construct(context);
              // this.super_space_vector_observer = new VectorObserver_Space_long_(RootContext.getFallbackCallContext(), this.super_space_vector);
              this.do_setSuperSpaces(context, super_space_vector);

          }
      }
      {   if (this.sub_space_vector_observer == null) {
              this.sub_space_vector = null;
              this.sub_space_vector = Factory_Vector_Space_long_.construct(context);
              // this.sub_space_vector_observer = new VectorObserver_Space_long_(RootContext.getFallbackCallContext(), this.sub_space_vector);
              this.do_setSubSpaces(context, sub_space_vector);

          }
      }
      {   if (this.known_space_vector_observer == null) {
              this.known_space_vector = null;
              this.known_space_vector = Factory_Vector_Space_long_.construct(context);
              // this.known_space_vector_observer = new VectorObserver_Space_long_(RootContext.getFallbackCallContext(), this.known_space_vector);
              this.do_setKnownSpaces(context, known_space_vector);

          }
      }
      {   if (this.service_vector_observer == null) {
              this.service_vector = null;
              this.service_vector = Factory_Vector_Service_long_.construct(context);
              // this.service_vector_observer = new VectorObserver_Service_long_(RootContext.getFallbackCallContext(), this.service_vector);
              this.do_setServices(context, service_vector);

          }
      }
      {   if (this.locator_vector_observer == null) {
              this.locator_vector = null;
              this.locator_vector = Factory_Vector_NamedLocator_long_.construct(context);
              // this.locator_vector_observer = new VectorObserver_NamedLocator_long_(RootContext.getFallbackCallContext(), this.locator_vector);
              this.do_setLocators(context, locator_vector);

          }
      }
      {   if (this.content_vector_observer == null) {
              this.content_vector = null;
              this.content_vector = Factory_Vector_Object_long_.construct(context);
              // this.content_vector_observer = new VectorObserver_Object_long_(RootContext.getFallbackCallContext(), this.content_vector);
              this.do_setContents(context, content_vector);

          }
      }
    }
    }

  protected boolean is_destroyed = false;

  public boolean getIsDestroyed(CallContext context) {
    return this.is_destroyed;
  }
  public void destroy (CallContext context) {
    if (!this.is_destroyed) {
      this.is_destroyed = true;
      this.destroyClass_Space(context);
    }
  }

  public ValidationFailure canDestroy (CallContext context) {
    return null;
  }

  protected void destroyClass_Space (CallContext call_context) {
    CallContext context = call_context;
  }
  
  public void finalize () throws Throwable {
    this.destroy(RootContext.getDestructionContext());
    super.finalize();
  }

    public void validateinstanceClass_Space(CallContext call_context) throws ValidationFailure {
        CallContext context = call_context;
        ValidationFailure vf = validateinstanceClass_Space(context, null);
        if (vf != null) { throw vf; }
    }
    
    public void validate(CallContext call_context) throws ValidationFailure {
        CallContext context = call_context;
        validateinstanceClass_Space(context);
    }

    protected ValidationFailure validateinstanceClass_Space(CallContext call_context, ValidationFailure vf) {
      CallContext context = call_context;
        
        try {
            validateId(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateName(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateSuperSpaces(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateSubSpaces(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateKnownSpaces(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateServices(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateLocators(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        try {
            validateContents(context);
        } catch (ValidationFailure vf2) {
            if (vf == null) {
                vf = ValidationFailure.createValidationFailure(context, ValidationStringPool.get(context, "0.0.0/* Some values are invalid */" ));
            }
            vf.addCause(context, vf2);
        }
        return vf;
    }

  
   public String defaultId(CallContext call_context) // uml interface attribute
   {  
     CallContext context = call_context;
     return "";
   } 
  protected String id;
  public String getId(CallContext call_context) // uml interface attribute
  { CallContext context = call_context;
    
    
    return this.id;
  }
  public void setId(CallContext call_context, String id) // uml interface attribute
  {CallContext context = call_context;
  
      
    
    this.id = id;
    
    
  }
  public void validateId(CallContext call_context) throws ValidationFailure{
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  
   public String defaultName(CallContext call_context) // uml interface attribute
   {  
     CallContext context = call_context;
     return "";
   } 
  protected String name;
  public String getName(CallContext call_context) // uml interface attribute
  { CallContext context = call_context;
    
    
    return this.name;
  }
  public void setName(CallContext call_context, String name) // uml interface attribute
  {CallContext context = call_context;
  
      
    
    this.name = name;
    
    
  }
  public void validateName(CallContext call_context) throws ValidationFailure{
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_Space_long_ super_space_vector_observer;
  protected Vector_Space_long_ super_space_vector;
  public Vector_Space_long_ getSuperSpaces(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_Space_long_ result = null;
    result = (this.super_space_vector_observer == null || this.super_space_vector_observer.getObserved(context) == null ? null : this.super_space_vector_observer);
    return result;
  }
  public void setSuperSpaces(CallContext call_context, Vector_Space_long_ super_space_vector) {
     CallContext context = call_context;
     do_setSuperSpaces(context,  super_space_vector);
  }

  final protected void do_setSuperSpaces(CallContext call_context, Vector_Space_long_ super_space_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (super_space_vector == null) {
        this.super_space_vector_observer = null;
     } else {
        if (this.super_space_vector_observer == null) {
           this.super_space_vector_observer = new VectorObserver_Space_long_(context, super_space_vector);
       } else {
           this.super_space_vector_observer.setObserved(context, super_space_vector);
       }
    }
    this.super_space_vector = super_space_vector;
    
    
    
  }
  public void validateSuperSpaces(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_Space_long_ sub_space_vector_observer;
  protected Vector_Space_long_ sub_space_vector;
  public Vector_Space_long_ getSubSpaces(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_Space_long_ result = null;
    result = (this.sub_space_vector_observer == null || this.sub_space_vector_observer.getObserved(context) == null ? null : this.sub_space_vector_observer);
    return result;
  }
  public void setSubSpaces(CallContext call_context, Vector_Space_long_ sub_space_vector) {
     CallContext context = call_context;
     do_setSubSpaces(context,  sub_space_vector);
  }

  final protected void do_setSubSpaces(CallContext call_context, Vector_Space_long_ sub_space_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (sub_space_vector == null) {
        this.sub_space_vector_observer = null;
     } else {
        if (this.sub_space_vector_observer == null) {
           this.sub_space_vector_observer = new VectorObserver_Space_long_(context, sub_space_vector);
       } else {
           this.sub_space_vector_observer.setObserved(context, sub_space_vector);
       }
    }
    this.sub_space_vector = sub_space_vector;
    
    
    
  }
  public void validateSubSpaces(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_Space_long_ known_space_vector_observer;
  protected Vector_Space_long_ known_space_vector;
  public Vector_Space_long_ getKnownSpaces(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_Space_long_ result = null;
    result = (this.known_space_vector_observer == null || this.known_space_vector_observer.getObserved(context) == null ? null : this.known_space_vector_observer);
    return result;
  }
  public void setKnownSpaces(CallContext call_context, Vector_Space_long_ known_space_vector) {
     CallContext context = call_context;
     do_setKnownSpaces(context,  known_space_vector);
  }

  final protected void do_setKnownSpaces(CallContext call_context, Vector_Space_long_ known_space_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (known_space_vector == null) {
        this.known_space_vector_observer = null;
     } else {
        if (this.known_space_vector_observer == null) {
           this.known_space_vector_observer = new VectorObserver_Space_long_(context, known_space_vector);
       } else {
           this.known_space_vector_observer.setObserved(context, known_space_vector);
       }
    }
    this.known_space_vector = known_space_vector;
    
    
    
  }
  public void validateKnownSpaces(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_Service_long_ service_vector_observer;
  protected Vector_Service_long_ service_vector;
  public Vector_Service_long_ getServices(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_Service_long_ result = null;
    result = (this.service_vector_observer == null || this.service_vector_observer.getObserved(context) == null ? null : this.service_vector_observer);
    return result;
  }
  public void setServices(CallContext call_context, Vector_Service_long_ service_vector) {
     CallContext context = call_context;
     do_setServices(context,  service_vector);
  }

  final protected void do_setServices(CallContext call_context, Vector_Service_long_ service_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (service_vector == null) {
        this.service_vector_observer = null;
     } else {
        if (this.service_vector_observer == null) {
           this.service_vector_observer = new VectorObserver_Service_long_(context, service_vector);
       } else {
           this.service_vector_observer.setObserved(context, service_vector);
       }
    }
    this.service_vector = service_vector;
    
    
    
  }
  public void validateServices(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_NamedLocator_long_ locator_vector_observer;
  protected Vector_NamedLocator_long_ locator_vector;
  public Vector_NamedLocator_long_ getLocators(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_NamedLocator_long_ result = null;
    result = (this.locator_vector_observer == null || this.locator_vector_observer.getObserved(context) == null ? null : this.locator_vector_observer);
    return result;
  }
  public void setLocators(CallContext call_context, Vector_NamedLocator_long_ locator_vector) {
     CallContext context = call_context;
     do_setLocators(context,  locator_vector);
  }

  final protected void do_setLocators(CallContext call_context, Vector_NamedLocator_long_ locator_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (locator_vector == null) {
        this.locator_vector_observer = null;
     } else {
        if (this.locator_vector_observer == null) {
           this.locator_vector_observer = new VectorObserver_NamedLocator_long_(context, locator_vector);
       } else {
           this.locator_vector_observer.setObserved(context, locator_vector);
       }
    }
    this.locator_vector = locator_vector;
    
    
    
  }
  public void validateLocators(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  protected VectorObserver_Object_long_ content_vector_observer;
  protected Vector_Object_long_ content_vector;
  public Vector_Object_long_ getContents(CallContext call_context) // uml association
  { CallContext context = call_context;
    
    
    
  Vector_Object_long_ result = null;
    result = (this.content_vector_observer == null || this.content_vector_observer.getObserved(context) == null ? null : this.content_vector_observer);
    return result;
  }
  public void setContents(CallContext call_context, Vector_Object_long_ content_vector) {
     CallContext context = call_context;
     do_setContents(context,  content_vector);
  }

  final protected void do_setContents(CallContext call_context, Vector_Object_long_ content_vector) // uml association
  {CallContext context = call_context;
    
    
    
     if (content_vector == null) {
        this.content_vector_observer = null;
     } else {
        if (this.content_vector_observer == null) {
           this.content_vector_observer = new VectorObserver_Object_long_(context, content_vector);
       } else {
           this.content_vector_observer.setObserved(context, content_vector);
       }
    }
    this.content_vector = content_vector;
    
    
    
  }
  public void validateContents(CallContext call_context) throws ValidationFailure {
   
    CallContext context = call_context;
    ValidationFailure vf = null;
    if (vf != null) { throw vf; }
  }
  public Space tryGetSubSpaceById (CallContext call_context, String id) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getSubSpaces(context) == null) { return null; }
    for (Space subspace : this.getSubSpaces(context).getIterable_Space_(context)) {
        if (subspace.getId(context).equals(id)) {
            return subspace;
        }
    }
    return null;
  }
  public Space tryGetSuperSpaceById (CallContext call_context, String id) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getSuperSpaces(context) == null) { return null; }
    for (Space superspace : this.getSuperSpaces(context).getIterable_Space_(context)) {
        if (superspace.getId(context).equals(id)) {
            return superspace;
        }
    }
    return null;
  }
  public Space tryGetKnownSpaceById (CallContext call_context, String id) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getKnownSpaces(context) == null) { return null; }
    for (Space knownspace : this.getKnownSpaces(context).getIterable_Space_(context)) {
        if (knownspace.getId(context).equals(id)) {
            return knownspace;
        }
    }
    return null;
  }
  public<ServiceClass> ServiceClass tryGetServiceByClass (CallContext call_context, Class<ServiceClass> service_class) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getServices(context) == null) { return null; }
    for (Service service : this.getServices(context).getIterable_Service_(context)) {
        if (service_class.isAssignableFrom(service.getClass())) {
            return (ServiceClass) service;
        }
    }
    return null;
  }
  public Locator tryGetLocatorByName (CallContext call_context, String name) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getLocators(context) == null) { return null; }
    for (Named<Locator> locator : this.getLocators(context).getIterable(context)) {
        if (locator.getName(context).equals(name)) {
            return locator.getData(context);
        }
    }
    return null;
  }
  public Locator tryGetLocatorByClass (CallContext call_context, String class_id) // uml interface operation
  { CallContext context = null;
   context = call_context; 
 if (this.getLocators(context) == null) { return null; }
    for (Named<Locator> locator : this.getLocators(context).getIterable(context)) {
        if (locator.getData(context).getLocatorClassId(context).equals(class_id)) {
            return locator.getData(context);
        }
    }
    return null;
  }
  

    
    
    
    
    
    
    
    
  

}

