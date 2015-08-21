package fr.inria.diverse.melange.ui

import fr.inria.diverse.melange.ui.internal.MelangeActivator
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.ui.plugin.AbstractUIPlugin

class MelangeUiModule extends AbstractMelangeUiModule
{
	new(AbstractUIPlugin plugin) {
		super(plugin)
	}

	def static void logErrorMessage(String message, Throwable e) {
		MelangeActivator.instance.log.log(
			new Status(
				IStatus::ERROR,
				MelangeActivator.instance.bundle.symbolicName,
				IStatus::ERROR, message,
				e
			)
		)
	}
}
