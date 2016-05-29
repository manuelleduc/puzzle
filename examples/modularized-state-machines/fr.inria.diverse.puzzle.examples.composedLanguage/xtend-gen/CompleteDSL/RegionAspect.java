package CompleteDSL;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import CompleteDSL.RegionAspectRegionAspectProperties;
import CompleteDSL.StateAspect;
import CompleteDSL.TransitionAspect;
import CompleteDSL.TriggerAspect;
import CompleteDSLPckg.AbstractState;
import CompleteDSLPckg.InitialState;
import CompleteDSLPckg.Pseudostate;
import CompleteDSLPckg.Region;
import CompleteDSLPckg.State;
import CompleteDSLPckg.Transition;
import CompleteDSLPckg.Trigger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import com.google.common.collect.Iterables;
import CompleteDSL.RegionAspectRegionAspectProperties;
import CompleteDSLPckg.AbstractState;
import CompleteDSLPckg.Region;
import CompleteDSLPckg.State;
import CompleteDSLPckg.Transition;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import puzzle.annotations.processor.AddExtensionMethod;
import puzzle.annotations.processor.OverrideRequiredAspectMethod;

@Aspect(className = Region.class)
@SuppressWarnings("all")
public class RegionAspect {
  public static void initRegion(final Region _self, final Hashtable<String, Object> context) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_initRegion(_self_, _self,context);
  }
  
  public static String getContextPathByRegion(final Region _self) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getContextPathByRegion(_self_, _self);
    return (java.lang.String)result;
  }
  
  /**
   * Performs a step in the state machine i.e., reads an entry of the input stack and executes it.
   * If there are several events in the same step they are executed sequentially.
   */
  public static void step(final Region _self, final Hashtable<String, Object> context, final EList<String> events) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_step(_self_, _self,context,events);
  }
  
  public static void removeStatesFromContext(final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> toRemove) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_removeStatesFromContext(_self_, _self,context,toRemove);
  }
  
  public static void addStatesToContext(final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> newStates) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_addStatesToContext(_self_, _self,context,newStates);
  }
  
  /**
   * Returns the current state of the machine. It corresponds to the current set of active states.
   */
  public static ArrayList<AbstractState> getCurrentState(final Region _self, final Hashtable<String, Object> context, final EList<String> events) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getCurrentState(_self_, _self,context,events);
    return (java.util.ArrayList<CompleteDSLPckg.AbstractState>)result;
  }
  
  /**
   * Returns the active transitions of a vertex
   */
  public static EList<Transition> getActiveTransitions(final Region _self, final AbstractState vertex, final EList<String> events) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getActiveTransitions(_self_, _self,vertex,events);
    return (org.eclipse.emf.common.util.EList<CompleteDSLPckg.Transition>)result;
  }
  
  /**
   * Finds the set of states that are active before the step and that will be left after the step.
   */
  public static void findOldActiveStates(final Region _self, final ArrayList<AbstractState> oldActiveStates, final Transition selectedTransition, final Hashtable<String, Object> context) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_findOldActiveStates(_self_, _self,oldActiveStates,selectedTransition,context);
  }
  
  /**
   * Finds the set of states that will be active after the step.
   */
  public static void findNewActiveStates(final Region _self, final ArrayList<AbstractState> newActiveStates, final Transition selectedTransition, final ArrayList<Transition> currentActiveTransitions, final Hashtable<String, Object> context) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_findNewActiveStates(_self_, _self,newActiveStates,selectedTransition,currentActiveTransitions,context);
  }
  
  /**
   * Finds the transitions that will be fired during the step.
   */
  public static void findNewActiveTransitions(final Region _self, final ArrayList<Transition> newActiveTransitions, final Transition selectedTransition, final Hashtable<String, Object> context) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_findNewActiveTransitions(_self_, _self,newActiveTransitions,selectedTransition,context);
  }
  
  protected static void _privk3_initRegion(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context) {
    ArrayList<AbstractState> regionCurrentState = new ArrayList<AbstractState>();
    String _contextPathByRegion = RegionAspect.getContextPathByRegion(_self);
    context.put(_contextPathByRegion, regionCurrentState);
    EList<AbstractState> _subvertex = _self.getSubvertex();
    final Function1<AbstractState, Boolean> _function = (AbstractState _vertex) -> {
      boolean _and = false;
      if (!(_vertex instanceof Pseudostate)) {
        _and = false;
      } else {
        _and = (_vertex instanceof InitialState);
      }
      return Boolean.valueOf(_and);
    };
    AbstractState _findFirst = IterableExtensions.<AbstractState>findFirst(_subvertex, _function);
    Pseudostate initialPseudostate = ((Pseudostate) _findFirst);
    ArrayList<AbstractState> initialCurrentState = new ArrayList<AbstractState>();
    ArrayList<Transition> initialCurrentTransitions = new ArrayList<Transition>();
    EList<Transition> _outgoing = initialPseudostate.getOutgoing();
    for (final Transition _transition : _outgoing) {
      {
        initialCurrentTransitions.add(_transition);
        AbstractState _target = _transition.getTarget();
        initialCurrentState.add(_target);
      }
    }
    ((ArrayList<AbstractState>) regionCurrentState).addAll(initialCurrentState);
    final Consumer<Transition> _function_1 = (Transition transition) -> {
      TransitionAspect.evalTransition(transition, context);
    };
    initialCurrentTransitions.forEach(_function_1);
  }
  
  protected static void _privk3_step(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final EList<String> events) {
    ArrayList<AbstractState> currentState = RegionAspect.getCurrentState(_self, context, events);
    ArrayList<Transition> currentTransitions = new ArrayList<Transition>();
    ArrayList<AbstractState> attendedStates = new ArrayList<AbstractState>();
    ArrayList<AbstractState> newStates = new ArrayList<AbstractState>();
    EList<Transition> activeTransitions = new BasicEList<Transition>();
    for (final AbstractState _state : currentState) {
      EList<Transition> _activeTransitions = RegionAspect.getActiveTransitions(_self, _state, events);
      activeTransitions.addAll(_activeTransitions);
    }
    for (final Transition transition : activeTransitions) {
      {
        RegionAspect.findOldActiveStates(_self, attendedStates, transition, context);
        RegionAspect.findNewActiveTransitions(_self, currentTransitions, transition, context);
        RegionAspect.findNewActiveStates(_self, newStates, transition, currentTransitions, context);
      }
    }
    for (final AbstractState _attendedState : attendedStates) {
      if ((_attendedState instanceof State)) {
        StateAspect.exitState(((State) _attendedState), context);
      }
    }
    RegionAspect.removeStatesFromContext(_self, context, attendedStates);
    RegionAspect.addStatesToContext(_self, context, newStates);
    final Consumer<Transition> _function = (Transition transition_1) -> {
      TransitionAspect.evalTransition(transition_1, context);
    };
    activeTransitions.forEach(_function);
    final Consumer<Transition> _function_1 = (Transition transition_1) -> {
      boolean _alreadyFired = TransitionAspect.alreadyFired(transition_1, context);
      boolean _not = (!_alreadyFired);
      if (_not) {
        TransitionAspect.evalTransition(transition_1, context);
      }
    };
    currentTransitions.forEach(_function_1);
    final Consumer<AbstractState> _function_2 = (AbstractState state) -> {
      EList<Transition> _outgoing = state.getOutgoing();
      final Consumer<Transition> _function_3 = (Transition transition_1) -> {
        TransitionAspect.resetFired(transition_1);
      };
      _outgoing.forEach(_function_3);
    };
    newStates.forEach(_function_2);
  }
  
  protected static ArrayList<AbstractState> _privk3_getCurrentState(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final EList<String> events) {
    final ArrayList<AbstractState> currentState = new ArrayList<AbstractState>();
    Set<String> _keySet = context.keySet();
    Iterator<String> _it = _keySet.iterator();
    while (_it.hasNext()) {
      {
        String _key = _it.next();
        Object _value = context.get(_key);
        String _name = _self.getName();
        String _plus = ("currentState-" + _name);
        boolean _startsWith = _key.startsWith(_plus);
        if (_startsWith) {
          final Consumer<AbstractState> _function = (AbstractState _vertex) -> {
            currentState.add(_vertex);
          };
          ((ArrayList<AbstractState>) _value).forEach(_function);
        }
      }
    }
    return currentState;
  }
  
  protected static EList<Transition> _privk3_getActiveTransitions(final RegionAspectRegionAspectProperties _self_, final Region _self, final AbstractState vertex, final EList<String> events) {
    final BasicEList<Transition> res = new BasicEList<Transition>();
    EList<Transition> _outgoing = vertex.getOutgoing();
    for (final Transition transition : _outgoing) {
      boolean _or = false;
      Trigger _trigger = transition.getTrigger();
      boolean _equals = Objects.equal(_trigger, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _and = false;
        Trigger _trigger_1 = transition.getTrigger();
        boolean _notEquals = (!Objects.equal(_trigger_1, null));
        if (!_notEquals) {
          _and = false;
        } else {
          Trigger _trigger_2 = transition.getTrigger();
          boolean _evalTrigger = TriggerAspect.evalTrigger(_trigger_2, events);
          _and = _evalTrigger;
        }
        _or = _and;
      }
      if (_or) {
        res.add(transition);
      }
    }
    return res;
  }
  
  protected static void _privk3_findNewActiveStates(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<AbstractState> newActiveStates, final Transition selectedTransition, final ArrayList<Transition> currentActiveTransitions, final Hashtable<String, Object> context) {
    final ArrayList<AbstractState> targetParents = new ArrayList<AbstractState>();
    AbstractState _target = selectedTransition.getTarget();
    RegionAspect.getAllParents(_self, _target, targetParents);
    final Consumer<AbstractState> _function = (AbstractState _parent) -> {
      boolean _contains = newActiveStates.contains(_parent);
      boolean _not = (!_contains);
      if (_not) {
        newActiveStates.add(_parent);
      }
    };
    targetParents.forEach(_function);
    for (final Transition _currentTransition : currentActiveTransitions) {
      RegionAspect._original_findNewActiveStates(_self_, _self, newActiveStates, _currentTransition, currentActiveTransitions, context);
    }
    ArrayList<AbstractState> toDelete = new ArrayList<AbstractState>();
    final ArrayList<AbstractState> targetChildren = new ArrayList<AbstractState>();
    AbstractState _source = selectedTransition.getSource();
    RegionAspect.getAllChildren(_self, _source, targetChildren);
    for (final AbstractState _newState : newActiveStates) {
      {
        boolean delete = true;
        List<Transition> transitions = new ArrayList<Transition>();
        EList<Transition> _incoming = _newState.getIncoming();
        transitions.addAll(_incoming);
        for (final AbstractState _children : targetChildren) {
          EList<Transition> _incoming_1 = _children.getIncoming();
          transitions.addAll(_incoming_1);
        }
        for (final Transition _incoming_2 : transitions) {
          {
            if ((_newState instanceof State)) {
              ArrayList<AbstractState> children = CollectionLiterals.<AbstractState>newArrayList();
              RegionAspect.getAllChildren(_self, _newState, children);
              final Function1<AbstractState, Boolean> _function_1 = (AbstractState child) -> {
                return Boolean.valueOf(newActiveStates.contains(child));
              };
              AbstractState _findFirst = IterableExtensions.<AbstractState>findFirst(children, _function_1);
              boolean _notEquals = (!Objects.equal(_findFirst, null));
              if (_notEquals) {
                delete = false;
              }
            }
            boolean _contains = currentActiveTransitions.contains(_incoming_2);
            if (_contains) {
              delete = false;
            }
          }
        }
        if (delete) {
          toDelete.add(_newState);
        }
      }
    }
    final ArrayList<AbstractState> moreToDelete = new ArrayList<AbstractState>();
    final Consumer<AbstractState> _function_1 = (AbstractState _state) -> {
      final ArrayList<AbstractState> child = new ArrayList<AbstractState>();
      RegionAspect.getAllChildren(_self, _state, child);
      boolean _and = false;
      EList<Transition> _incoming = _state.getIncoming();
      final Function1<Transition, Boolean> _function_2 = (Transition t) -> {
        return Boolean.valueOf(currentActiveTransitions.contains(t));
      };
      boolean _exists = IterableExtensions.<Transition>exists(_incoming, _function_2);
      boolean _not = (!_exists);
      if (!_not) {
        _and = false;
      } else {
        final Function1<AbstractState, Boolean> _function_3 = (AbstractState s) -> {
          EList<Transition> _incoming_1 = s.getIncoming();
          final Function1<Transition, Boolean> _function_4 = (Transition t) -> {
            return Boolean.valueOf(currentActiveTransitions.contains(t));
          };
          return Boolean.valueOf(IterableExtensions.<Transition>exists(_incoming_1, _function_4));
        };
        boolean _exists_1 = IterableExtensions.<AbstractState>exists(child, _function_3);
        boolean _not_1 = (!_exists_1);
        _and = _not_1;
      }
      if (_and) {
        moreToDelete.add(_state);
      }
    };
    newActiveStates.forEach(_function_1);
    toDelete.addAll(moreToDelete);
    newActiveStates.removeAll(toDelete);
  }

protected static void _original_findNewActiveStates(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<AbstractState> newActiveStates, final Transition selectedTransition, final ArrayList<Transition> currentActiveTransitions, final Hashtable<String, Object> context) {
    boolean _and = false;
    AbstractState _target = selectedTransition.getTarget();
    boolean _contains = newActiveStates.contains(_target);
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      boolean _alreadyFired = TransitionAspect.alreadyFired(selectedTransition, context);
      boolean _not_1 = (!_alreadyFired);
      _and = _not_1;
    }
    if (_and) {
      AbstractState _target_1 = selectedTransition.getTarget();
      newActiveStates.add(_target_1);
    }
  }

protected static void _privk3_findOldActiveStates(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<AbstractState> oldActiveStates, final Transition selectedTransition, final Hashtable<String, Object> context) {
    RegionAspect._original_findOldActiveStates(_self_, _self, oldActiveStates, selectedTransition, context);
    final ArrayList<AbstractState> sourceChildren = new ArrayList<AbstractState>();
    AbstractState _source = selectedTransition.getSource();
    RegionAspect.getAllChildren(_self, _source, sourceChildren);
    final Consumer<AbstractState> _function = (AbstractState _children) -> {
      boolean _contains = oldActiveStates.contains(_children);
      boolean _not = (!_contains);
      if (_not) {
        oldActiveStates.add(_children);
      }
    };
    sourceChildren.forEach(_function);
    final ArrayList<AbstractState> sourceParents = new ArrayList<AbstractState>();
    AbstractState _source_1 = selectedTransition.getSource();
    RegionAspect.getAllParents(_self, _source_1, sourceParents);
    final ArrayList<AbstractState> targetParents = new ArrayList<AbstractState>();
    AbstractState _target = selectedTransition.getTarget();
    RegionAspect.getAllParents(_self, _target, targetParents);
    final Function1<AbstractState, Boolean> _function_1 = (AbstractState _parent) -> {
      boolean _contains = targetParents.contains(_parent);
      return Boolean.valueOf((!_contains));
    };
    Iterable<AbstractState> leavingParents = IterableExtensions.<AbstractState>filter(sourceParents, _function_1);
    Iterables.<AbstractState>addAll(oldActiveStates, leavingParents);
  }

protected static void _original_findOldActiveStates(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<AbstractState> oldActiveStates, final Transition selectedTransition, final Hashtable<String, Object> context) {
    AbstractState _source = selectedTransition.getSource();
    boolean _contains = oldActiveStates.contains(_source);
    boolean _not = (!_contains);
    if (_not) {
      AbstractState _source_1 = selectedTransition.getSource();
      oldActiveStates.add(_source_1);
    }
  }

protected static void _privk3_findNewActiveTransitions(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<Transition> newActiveTransitions, final Transition selectedTransition, final Hashtable<String, Object> context) {
    newActiveTransitions.add(selectedTransition);
    ArrayList<Transition> activeTransitions = new ArrayList<Transition>();
    activeTransitions.addAll(newActiveTransitions);
    activeTransitions.add(selectedTransition);
    boolean conflictingTransition = RegionAspect.highestConflictingTransition(_self, activeTransitions);
    if ((!conflictingTransition)) {
      RegionAspect._original_findNewActiveTransitions(_self_, _self, newActiveTransitions, selectedTransition, context);
    } else {
      newActiveTransitions.clear();
      newActiveTransitions.addAll(activeTransitions);
    }
  }

protected static void _original_findNewActiveTransitions(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<Transition> newActiveTransitions, final Transition selectedTransition, final Hashtable<String, Object> context) {
    newActiveTransitions.add(selectedTransition);
  }

protected static String _privk3_getContextPathByRegion(final RegionAspectRegionAspectProperties _self_, final Region _self) {
    String root = "currentState";
    ArrayList<Region> parentRegions = new ArrayList<Region>();
    Region currentRegion = _self;
    while (((!Objects.equal(currentRegion.getOwnerState(), null)) && (!Objects.equal(currentRegion.getOwnerState().getOwnerRegion(), null)))) {
      {
        State _ownerState = _self.getOwnerState();
        Region _ownerRegion = _ownerState.getOwnerRegion();
        parentRegions.add(_ownerRegion);
        State _ownerState_1 = currentRegion.getOwnerState();
        Region _ownerRegion_1 = _ownerState_1.getOwnerRegion();
        currentRegion = _ownerRegion_1;
      }
    }
    for (int i = (parentRegions.size() - 1); (i >= 0); i--) {
      String _root = root;
      Region _get = parentRegions.get(i);
      String _name = _get.getName();
      String _plus = ("-" + _name);
      root = (_root + _plus);
    }
    String _name = _self.getName();
    return ((root + "-") + _name);
  }

protected static String _original_getContextPathByRegion(final RegionAspectRegionAspectProperties _self_, final Region _self) {
    String _name = _self.getName();
    return ("currentState-" + _name);
  }

protected static void _privk3_removeStatesFromContext(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> toRemove) {
    for (final AbstractState _oldState : toRemove) {
      String _contextPath = RegionAspect.getContextPath(_self, _oldState);
      Object _get = context.get(_contextPath);
      ((ArrayList<AbstractState>) _get).remove(_oldState);
    }
  }

protected static void _original_removeStatesFromContext(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> toRemove) {
    String _contextPathByRegion = RegionAspect.getContextPathByRegion(_self);
    Object _get = context.get(_contextPathByRegion);
    ((ArrayList<AbstractState>) _get).removeAll(toRemove);
  }

protected static void _privk3_addStatesToContext(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> newStates) {
    for (final AbstractState _newState : newStates) {
      {
        String path = RegionAspect.getContextPath(_self, _newState);
        Object _get = context.get(path);
        boolean _equals = Objects.equal(_get, null);
        if (_equals) {
          ArrayList<AbstractState> _arrayList = new ArrayList<AbstractState>();
          context.put(path, _arrayList);
        }
        Object _get_1 = context.get(path);
        boolean _contains = ((ArrayList<AbstractState>) _get_1).contains(_newState);
        boolean _not = (!_contains);
        if (_not) {
          Object _get_2 = context.get(path);
          ((ArrayList<AbstractState>) _get_2).add(_newState);
        }
      }
    }
  }

protected static void _original_addStatesToContext(final RegionAspectRegionAspectProperties _self_, final Region _self, final Hashtable<String, Object> context, final ArrayList<AbstractState> newStates) {
    for (final AbstractState _newState : newStates) {
      String _contextPathByRegion = RegionAspect.getContextPathByRegion(_self);
      Object _get = context.get(_contextPathByRegion);
      boolean _contains = ((ArrayList<AbstractState>) _get).contains(_newState);
      boolean _not = (!_contains);
      if (_not) {
        String _contextPathByRegion_1 = RegionAspect.getContextPathByRegion(_self);
        Object _get_1 = context.get(_contextPathByRegion_1);
        ((ArrayList<AbstractState>) _get_1).add(_newState);
      }
    }
  }

@AddExtensionMethod
  public static void getAllParents(final Region _self, final AbstractState vertex, final ArrayList<AbstractState> parents) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_getAllParents(_self_, _self,vertex,parents);
  }

protected static void _privk3_getAllParents(final RegionAspectRegionAspectProperties _self_, final Region _self, final AbstractState vertex, final ArrayList<AbstractState> parents) {
    if ((vertex instanceof State)) {
      Region _ownerRegion = ((State) vertex).getOwnerRegion();
      State superState = _ownerRegion.getOwnerState();
      while ((!Objects.equal(superState, null))) {
        {
          boolean _contains = parents.contains(superState);
          boolean _not = (!_contains);
          if (_not) {
            parents.add(superState);
          }
          Region _ownerRegion_1 = superState.getOwnerRegion();
          State _ownerState = _ownerRegion_1.getOwnerState();
          superState = _ownerState;
        }
      }
    }
  }

@AddExtensionMethod
  public static void getAllChildren(final Region _self, final AbstractState vertex, final ArrayList<AbstractState> children) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    _privk3_getAllChildren(_self_, _self,vertex,children);
  }

protected static void _privk3_getAllChildren(final RegionAspectRegionAspectProperties _self_, final Region _self, final AbstractState vertex, final ArrayList<AbstractState> children) {
    if ((vertex instanceof State)) {
      EList<Region> _ownedRegions = ((State) vertex).getOwnedRegions();
      boolean _notEquals = (!Objects.equal(_ownedRegions, null));
      if (_notEquals) {
        EList<Region> _ownedRegions_1 = ((State) vertex).getOwnedRegions();
        final Consumer<Region> _function = (Region _region) -> {
          EList<AbstractState> _subvertex = _region.getSubvertex();
          children.addAll(_subvertex);
          EList<AbstractState> _subvertex_1 = _region.getSubvertex();
          final Consumer<AbstractState> _function_1 = (AbstractState _vertex) -> {
            RegionAspect.getAllChildren(_self, _vertex, children);
          };
          _subvertex_1.forEach(_function_1);
        };
        _ownedRegions_1.forEach(_function);
      }
    }
  }

@AddExtensionMethod
  public static boolean highestConflictingTransition(final Region _self, final ArrayList<Transition> activeTransitions) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_highestConflictingTransition(_self_, _self,activeTransitions);
    return (boolean)result;
  }

protected static boolean _privk3_highestConflictingTransition(final RegionAspectRegionAspectProperties _self_, final Region _self, final ArrayList<Transition> activeTransitions) {
    final int res = activeTransitions.size();
    final ArrayList<Transition> toDelete = new ArrayList<Transition>();
    final Consumer<Transition> _function = (Transition x) -> {
      final Consumer<Transition> _function_1 = (Transition y) -> {
        AbstractState _source = x.getSource();
        if ((_source instanceof State)) {
          ArrayList<AbstractState> children = new ArrayList<AbstractState>();
          AbstractState _source_1 = x.getSource();
          RegionAspect.getAllChildren(_self, ((State) _source_1), children);
          AbstractState _source_2 = y.getSource();
          boolean _contains = children.contains(_source_2);
          if (_contains) {
            toDelete.add(y);
          }
        }
      };
      activeTransitions.forEach(_function_1);
    };
    activeTransitions.forEach(_function);
    activeTransitions.removeAll(toDelete);
    int _size = activeTransitions.size();
    return (res != _size);
  }

@AddExtensionMethod
  public static String getContextPath(final Region _self, final AbstractState _vertex) {
    CompleteDSL.RegionAspectRegionAspectProperties _self_ = CompleteDSL.RegionAspectRegionAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getContextPath(_self_, _self,_vertex);
    return (java.lang.String)result;
  }

protected static String _privk3_getContextPath(final RegionAspectRegionAspectProperties _self_, final Region _self, final AbstractState _vertex) {
    String root = "currentState";
    ArrayList<Region> parentRegions = new ArrayList<Region>();
    Region currentRegion = _vertex.getOwnerRegion();
    while ((!Objects.equal(currentRegion, null))) {
      {
        parentRegions.add(currentRegion);
        State _ownerState = currentRegion.getOwnerState();
        boolean _notEquals = (!Objects.equal(_ownerState, null));
        if (_notEquals) {
          State _ownerState_1 = currentRegion.getOwnerState();
          Region _ownerRegion = _ownerState_1.getOwnerRegion();
          currentRegion = _ownerRegion;
        } else {
          currentRegion = null;
        }
      }
    }
    for (int i = (parentRegions.size() - 1); (i >= 0); i--) {
      String _root = root;
      Region _get = parentRegions.get(i);
      String _name = _get.getName();
      String _plus = ("-" + _name);
      root = (_root + _plus);
    }
    return root;
  }
}
