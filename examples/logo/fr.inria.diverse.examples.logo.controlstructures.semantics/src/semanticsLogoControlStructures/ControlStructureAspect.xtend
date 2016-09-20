package semanticsLogoControlStructures

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import java.util.Hashtable

import ControlStructures.ControlStructure
import ControlStructures.If
import ControlStructures.While
import ControlStructures.Block

import static extension semanticsLogoControlStructures.IfAspect.*
import static extension semanticsLogoControlStructures.WhileAspect.*
import static extension semanticsLogoControlStructures.BlockAspect.*

@Aspect(className=ControlStructure)
class ControlStructureAspect {
	
	def void eval(Hashtable<String, Object> context){
		if(_self instanceof If){
			var If _if = _self as If
			_if.eval(context)
		}
		else if(_self instanceof While){
			var While _while = _self as While
			_while.eval(context)
		}
		else if(_self instanceof Block){
			var Block _block = _self as Block
			_block.eval(context)
		}
	}
}