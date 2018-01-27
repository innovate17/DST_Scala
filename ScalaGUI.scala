import scala.swing._
import BorderPanel.Position._
object ScalaGUI{

	val textArea = new TextArea

	def openFile(){
		val chooser = new FileChooser
		if(chooser.showOpenDialog(null) == FileChooser.Result.Approve){
			val source = scala.io.Source.fromFile(chooser.selectedFile)
			textArea.text =  source.mkString
			source.close()
		}
	}

	def saveFile(){
		val chooser = new FileChooser
		if(chooser.showSaveDialog(null) == FileChooser.Result.Approve){
			val printer = new java.io.PrintWriter(chooser.selectedFile)
			printer.print(textArea.text)
			printer.close()
		}
	}

	def main(args : Array[String]) : Unit = {
		val frame = new MainFrame{
			title = "My First GUI"
			contents = new ScrollPane(textArea)
			menuBar = new MenuBar{
				contents += new Menu("File"){
					contents += new MenuItem(
						Action("Open"){
							println("Open has been called")
							openFile
						}
					)
					contents += new MenuItem(
						Action("Save"){
							println("Save has been called")
							saveFile
						}
					)
					contents += new Separator
					contents += new MenuItem(
						Action("Exit"){
							println("Good Bye !")
							sys.exit(0)
						}
					)

				}
			}
			size = new Dimension(800,800)
			centerOnScreen
		}
		frame.visible = true
	}
}