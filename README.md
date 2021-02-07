# Desklo
Desklo is a ticket manager for service desk teams. This is a didactic Java project intended to teach desktop graphical user interface to students of the bilingual systems development technician course from SENAC/São Leopoldo.

## Getting started - student environment setup

This project is managed with the Git version control system and developed with the Netbeans integrated development environment (IDE). 

### Git

First, download the git client at https://git-scm.com/

Then, you can fork the Desklo project to your profile. To do this, go the address https://github.com/hdvianna/desklo and click on the fork button (see Figure 1). A popup will be opened asking "Where should we fork sample?". The select your profile.

After installing the git and forking the repository you can open a terminal (or command prompt) to clone the repository using the following command `git clone https://github.com/<my-user-name>/desklo.git`, where my `<my-user-name>` is the name of your GitHub profile. For example, 

```bash
git clone https://github.com/luigivercottidev/desklo.git
```

**[Figure 1 - GitHub Fork button]**

![GitHub Desklo repository screenshot highlighting the Fork button in red](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/fork-button.png "Figure 1")


### JDK

Go to the address https://www.oracle.com/java/technologies/javase-jdk15-downloads.html and download the installer suitable for your operating system (Windows, Linux, or macOS). Then execute the installer after its download.

### NetBeans IDE

Go to the address https://netbeans.apache.org/download/nb120/nb120.html and download the installer suitable for your operating system (Windows, Linux, or macOS). Then execute the installer after its download.

### Opening the project

Run the NetBeans IDE. After starting NetBeans click in the `File` menu, then `New Project`. A dialog will open for you to select the type of the project. In the `Categories` list select `Java with Ant`, in the projects list select `Java Project with Existing Sources`, then click on the `Next` button (see Figure 2). 

**[Figure 2 - NetBeans "New Project" dialog (step 1)]**
![NetBeans New Project dialog step 1, highlighting in red the Categories list, Projects list, and the Next button. Java wih Ant is selected in the Categories list and Java Project with Existing Sources is selected in the Projects list](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-type.png "Figure 2")

In the next step (`Finding Feature`) unmark all checkboxes and click on the `Activate` button. You will need to wait for a few seconds while the feature is being activated (see Figure 3).

**[Figure 3 - NetBeans "New Project" dialog (step 2)]**
![NetBeans New Project dialog step 2 highlighting in red the Activate button](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-feature.png "Figure 3")

In the next step, type in `Desklo` in the Project Name field. Then click on the `Browse...` button and then select the location where you saved the Desklo repository. After selecting the location click on the `Finish` button (see Figure 4).

**[Figure 4 - NetBeans "New Project" dialog (step 3)]**
![NetBeans New Project dialog step 3 highlighting in red the Project Name field, the Browse... button, and the Finish button](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/new-project-finish.png "Figure 4")

Now click in the `File` menu and then in the `Project Properties` (if this item is disabled try to click the Desklo item in the Projects tree, see Figure 5, and try again). In the Project Properties dialog, select the categories `Sources` and click on the button `Add Folder...` from the `Source Package Folders` session (Figure 6). Then select the folder `src` (from the desklo repository location) then click Ok, and click Ok again.

**[Figure 5 - Projects Tree]**

![NetBeans Projects Tree](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/projects-tree.png "Figure 5")

**[Figure 6 - Project Sources Settings]**
![NetBeans Project Sources Settings](https://raw.githubusercontent.com/hdvianna/desklo/main/intructions/project-sources.png "Figure 6")
