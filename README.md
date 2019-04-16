##TWU Biblioteca Assignment

After running the application the user can put in various commands.
- 'listbooks' and 'listmovies' shows the list of available books and movies.
- 'login [username] [password]' logs the user in (currently only one dummy user available)
- 'mycontact' displays a logged in user's name, e-mail address, and phone number.
- 'checkoutbook' and 'checkoutmovie' let's a _logged in_ user checkout a book or movie
- 'return book' and 'returnmovie' returns a book or movie (which can only be returned if it's a book/movie from the library)
- 'quit' exists the application.

###Technical Decisions

My solution of the Biblioteca assignment uses a command pattern in it's core. In order to add a new command, one has to add a new implementation of `LibraryExecutable` to the Map `exectuables` in the class `Option`. This new command is then present in the application.

Instructions to push your code to code.google.com
=================================================
1. Sign into GitHub and create a new repository
        Repository name: twu-biblioteca-yourname
        Privacy level: Public
        Don't check "Initialize this repository with a README"
        Add .gitignore: None
        Add a license: Apache License 2.0

2. Run 'git init' in the folder that was extracted from the downloaded .zip file, in order to
 initialize local repository.

3. Make a local commit.
    $ git add -A
    $ git commit -m “Initial commit”

(Dont forget to add the hidden .idea folder, as it will make opening your project in Intellij easier.)

4. After you are done with the local commit, you can share your code with "The World" by pushing it to your
 GitHub repository.
    $ git remote add origin https://github.com/<YOUR-GITHUB-USERNAME>/twu-biblioteca-<YOURNAME>
    $ git push origin master

Instructions to open your code in Intellij
==========================================
1. Go to File -> Open (or Open Project)
2. Select the directory containing the code
DONE !

