var G = new jsnx.DiGraph();
G.addNodesFrom(["NamedElement","State","Trigger","Pseudostate","PseudostateKind","FinalState","Constraint","RelationalConstraint","Statement","Program","Conditional","Loop","VarDecl","Expression","Literal","IntegerLit","StringLit","BoolLit","ArithmeticExpression","ArithmeticOperator","RelationalExpression","RelationalOperator","VarReference","ConsoleOutput","Println","Print","Assignation","Wait"], {group:0});
G.addNodesFrom(["StateMachine","AbstractState","Transition"], {group:1});
G.addNodesFrom(["StateMachine","Region","AbstractState"], {group:2});
G.addNodesFrom(["Transition"], {group:3});
G.addNodesFrom(["Transition"], {group:4});

G.addEdgesFrom([["StateMachine","AbstractState"],["StateMachine","Transition"],["AbstractState","Transition"],["AbstractState","Transition"],["State","Program"],["State","Program"],["State","Program"],["Transition","Trigger"],["Transition","AbstractState"],["Transition","AbstractState"],["Transition","Statement"],["Transition","Constraint"],["Pseudostate","PseudostateKind"],["RelationalConstraint","Expression"],["Program","Statement"],["Conditional","Expression"],["Conditional","Program"],["Loop","Expression"],["Loop","Program"],["VarDecl","Expression"],["ArithmeticExpression","ArithmeticOperator"],["ArithmeticExpression","Expression"],["ArithmeticExpression","Expression"],["RelationalExpression","RelationalOperator"],["RelationalExpression","Expression"],["RelationalExpression","Expression"],["Assignation","VarDecl"],["Assignation","Expression"],["StateMachine","Region"],["Region","AbstractState"],["Region","Transition"],["AbstractState","Transition"],["AbstractState","Transition"],["AbstractState","Region"],["Transition","Trigger"],["Transition","AbstractState"],["Transition","AbstractState"],["Transition","Constraint"],["Transition","Trigger"],["Transition","AbstractState"],["Transition","AbstractState"],["Transition","Constraint"],["StateMachine","NamedElement"],["AbstractState","NamedElement"],["State","AbstractState"],["Transition","NamedElement"],["Pseudostate","AbstractState"],["FinalState","State"],["RelationalConstraint","Constraint"],["Program","Statement"],["Conditional","Statement"],["Loop","Statement"],["VarDecl","Statement"],["Literal","Expression"],["IntegerLit","Literal"],["StringLit","Literal"],["BoolLit","Literal"],["ArithmeticExpression","Expression"],["RelationalExpression","Expression"],["VarReference","Expression"],["ConsoleOutput","Statement"],["Println","ConsoleOutput"],["Print","ConsoleOutput"],["Assignation","Statement"],["Wait","Statement"],["StateMachine","NamedElement"],["Region","NamedElement"],["AbstractState","NamedElement"],["Transition","NamedElement"],["Transition","NamedElement"]]);