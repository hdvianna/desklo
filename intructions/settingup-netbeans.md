# NetBeans IDE

Go to the address https://netbeans.apache.org/download/nb120/nb120.html and download the installer suitable for your operating system (Windows, Linux, or macOS). Then execute the installer after its download.

## Opening the project

Run the NetBeans IDE. After starting NetBeans click in the `File` menu, then `New Project`. A dialog will open for you to select the type of the project. In the `Categories` list select `Java with Ant`, in the projects list select `Java Project with Existing Sources`, then click on the `Next` button (see Figure 1). 

**[Figure 1 - NetBeans "New Project" dialog (step 1)]**
![NetBeans New Project dialog step 1, highlighting in red the Categories list, Projects list, and the Next button. Java wih Ant is selected in the Categories list and Java Project with Existing Sources is selected in the Projects list](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-type.png "Figure 1")

In the next step (`Finding Feature`) unmark all checkboxes and click on the `Activate` button. You will need to wait for a few seconds while the feature is being activated (see Figure 2).

**[Figure 2 - NetBeans "New Project" dialog (step 2)]**
![NetBeans New Project dialog step 2 highlighting in red the Activate button](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-feature.png "Figure 2")

In the next step, type in `Desklo` in the Project Name field. Then click on the `Browse...` button and then select the location where you saved the Desklo repository. After selecting the location click on the `Finish` button (see Figure 3).

**[Figure 3 - NetBeans "New Project" dialog (step 3)]**
![NetBeans New Project dialog step 3 highlighting in red the Project Name field, the Browse... button, and the Finish button](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-finish.png "Figure 3")

Now click in the `File` menu and then in the `Project Properties` (if this item is disabled try to click the Desklo item in the Projects tree, see Figure 4, and try again). In the Project Properties dialog, select the categories `Sources` and click on the button `Add Folder...` from the `Source Package Folders` session (Figure 5). Then select the folder `src` (from the desklo repository location) then click Ok, and click Ok again.

**[Figure 4 - Projects Tree]**

![NetBeans Projects Tree](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/projects-tree.png "Figure 4")

**[Figure 5 - Project Sources Settings]**
![NetBeans Project Sources Settings](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/project-sources.png "Figure 5")

## Running the project

After the project opened, in the Project tab, right-click the item "Desklo", then click in "Clean and Build" (see Figure 6). Figure 7 shows the expected output from the building process.

**[Figure 6 - Building]**

![Netbeans project context menu ](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/build.png "Figure 6")

**[Figure 7 - Building Result]**
![Desklo building output](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/build-output.png "Figure 7")


To run the project press the F6 key. You shall see the a window similar to the presented in Figure 8.

**[Figure 8 - Desklo Main Window]**
![Desklo main window](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/desklo-main.png "Figure 8")