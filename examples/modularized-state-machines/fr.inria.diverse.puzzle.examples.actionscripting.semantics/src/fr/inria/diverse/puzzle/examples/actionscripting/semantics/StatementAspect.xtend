package fr.inria.diverse.puzzle.examples.actionscripting.semantics

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Main

import actionscripting.Statement
import actionscripting.Block
import actionscripting.Conditional
import actionscripting.Loop
import actionscripting.VarDecl
import actionscripting.Assignation
import actionscripting.Print
import actionscripting.Println
import actionscripting.Wait

import java.util.Hashtable

import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.BlockAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.ConditionalAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.LoopAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.VarDeclAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.AssignationAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.PrintAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.PrintlnAspect.*
import static extension fr.inria.diverse.puzzle.examples.actionscripting.semantics.WaitAspect.*


@Aspect(className=Statement)
class StatementAspect {
	
	@Main
	def void evalStatement(Hashtable<String, Object> context){
		if(_self instanceof Block){
			(_self as Block).evalStatement(context)
		}
		else if(_self instanceof Conditional){
			(_self as Conditional).evalStatement(context)
		}
		else if(_self instanceof Loop){
			(_self as Loop).evalStatement(context)
		}
		else if(_self instanceof VarDecl){
			(_self as VarDecl).evalStatement(context)
		}
		else if(_self instanceof Assignation){
			(_self as Assignation).evalStatement(context)
		}
		else if(_self instanceof Print){
			(_self as Print).evalStatement(context)
		}
		else if(_self instanceof Println){
			(_self as Println).evalStatement(context)
		}
		else if(_self instanceof Wait){
			(_self as Wait).evalStatement(context)
		}
	}
}