JOptionPane.showMessageDialog(
	frame, "Hello, world!",
	"Hello dialog",
	JOptionPane.ERROR_MESSAGE|INFORMATION_MESSAGE|PLAIN_MESSAGE|QUESTION_MESSAGE|WARNING_MESSAGE
	[, icon]);
	
int response = JOptionPane.showConfirmDialog(frame, "Exit?"); // Возвращает JOptionPane.CANCEL_OPTION|CLOSED|OPTION|NO_OPTION|YES_OPTION
JOptionPane.showConfirmDialog(
	frame, "Hello, world!",
	"Hello dialog",
	JOptionPane.YES_NO_OPTION|YES_NO_CANCEL_OPTION,
	JOptionPane.ERROR_MESSAGE|INFORMATION_MESSAGE|PLAIN_MESSAGE|QUESTION_MESSAGE|WARNING_MESSAGE
	[, icon]);
	
String response = JOptionPane.showInputDialog([frame, ]"message");
String response = JOptionPane.showInputDialog([frame, ]"message"[, initVal]);
String response = JOptionPane.showInputDialog([frame, ]"message", title, JOptionPane.ERROR_MESSAGE|INFORMATION_MESSAGE|PLAIN_MESSAGE|QUESTION_MESSAGE|WARNING_MESSAGE);
String response = JOptionPane.showInputDialopg(frame,
	message,
	title,
	JOptionPane.ERROR_MESSAGE|INFORMATION_MESSAGE|PLAIN_MESSAGE|QUESTION_MESSAGE|WARNING_MESSAGE,
	icon,
	vals,
	initVal);
	
JOptionPane.showOptionDialog(parent, msg, title, JOptionPane.YES_NO_OPTION|YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE|INFORMATION_MESSAGE|PLAIN_MESSAGE|QUESTION_MESSAGE|WARNING_MESSAGE, icon, options[], initVal);

JDialog dialog = new JDialog(parent, title, isModal);
dialog.dispose(); // Окончательное скрытие окна

JFileChooser chooser = new JFileChooser(File dir);
JFileChooser chooser = new JFileChooser(String dir);
chooser.showOpenDialog(parent);
chooser.showCloseDialog(parent);
chooser.showDialog(parent, String name);
chooser.setDialogTitle("Title");
// Возвращает JFileChooser.APPROVE_OPTION|CANCEL_OPTION|ERROR_OPTION
chooser.getSelectedFile(); // Возвращает имя выбранного файла
chooser.setFileFilter(filter); // Установить фильр файлов
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY|DIRECTORIES_ONLY|FILES_AND_DIRECTORIES); // Режим выбора файлов
File currentDir = chooser.getCurrentDirectory();
chooser.setMultiSelectionEnabled(true); // Разрешение множественного выбора
File[] files = chooser.getSelectedFiles(); // Возвращает выбранные файлы
chooser.setFileHidingEnabled(true); // Разрешения показа скрытых файлов

// import javax.swing.filechooser.FileFilter;
class MyFilter extends FileFilter{
	public boolean accept(File file) {
		if(file.isDirectory()) return true;
		if(file.getName().endsWith(".txt")) return true;
		return false;
	}
	
	public String getDescription() {
		return "";
	}


Color color = JColorChooser.showDialog(frame, "Выберите цвет", Color.WHITE); // Отображение окна выбора цвета