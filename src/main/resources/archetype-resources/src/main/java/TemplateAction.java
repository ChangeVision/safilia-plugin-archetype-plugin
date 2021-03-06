#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};


import javax.swing.JOptionPane;

import com.change_vision.safilia.api.inf.SafiliaAPI;
import com.change_vision.safilia.api.inf.exception.ProjectNotFoundException;
import com.change_vision.safilia.api.inf.project.ProjectAccessor;
import com.change_vision.safilia.api.inf.ui.IPluginActionDelegate;
import com.change_vision.safilia.api.inf.ui.IWindow;

public class TemplateAction implements IPluginActionDelegate {

	public Object run(IWindow window) throws UnExpectedException {
	    try {
	        SafiliaAPI api = SafiliaAPI.getSafiliaAPI();
	        ProjectAccessor projectAccessor = api.getProjectAccessor();
	        projectAccessor.getProject();
	        JOptionPane.showMessageDialog(window.getParent(),"Hello");
	    } catch (ProjectNotFoundException e) {
	        String message = "Project is not opened.Please open the project or create new project.";
			JOptionPane.showMessageDialog(window.getParent(), message, "Warning", JOptionPane.WARNING_MESSAGE); 
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(window.getParent(), "Unexpected error has occurred.", "Alert", JOptionPane.ERROR_MESSAGE); 
	        throw new UnExpectedException();
	    }
	    return null;
	}


}
