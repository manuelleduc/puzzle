package semanticsLogo

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import static extension semanticsLogo.LogoProgramAspect.*
import java.util.Hashtable
import java.util.ArrayList
import Logo.LogoPackage
import Logo.LogoProgram

class Interpreter {

	new() {
	}

	def eval(String modelPath) {
		var fact = new XMIResourceFactoryImpl
		if (!EPackage.Registry.INSTANCE.containsKey(LogoPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(LogoPackage.eNS_URI, LogoPackage.eINSTANCE);
		}
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", fact);

		var rs = new ResourceSetImpl()

		var uri = URI.createFileURI(modelPath);
		var res = rs.getResource(uri, true);
		var LogoProgram logo = res.contents.get(0) as LogoProgram
		var Hashtable<String, Object> context = new Hashtable<String, Object>()
		
		var Turtle turtle = new Turtle()
		var ArrayList<Hashtable<String,Integer>> stack = new ArrayList<Hashtable<String,Integer>>()
		var Hashtable<String, Object> variablesTable = new Hashtable<String, Object>()
		
		context.put('turtle', turtle)
		context.put('stack', stack)
		context.put('variables', variablesTable)
		
		logo.eval(context)
		new Window (context.get('turtle') as Turtle)
	}
	
	def static void main(String[] args){
//		(new Interpreter()).eval('models/SimpleLogo.xmi')
//		(new Interpreter()).eval('models/VariablesLogo.xmi')
		(new Interpreter()).eval('models/ControlStructuresLogo.xmi')
	}
}
