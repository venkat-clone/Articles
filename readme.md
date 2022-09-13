
# QuoteDiary

Dairy app with build in Wallpapers and Quotes. User can set any Wallpaper from the app in self and quotes can be placed on the home screen as Widget. Dairy will be stored in backend server



### preview
![Presentations are communication tools that can be used as demonstrations, lectures, speeches, reports, and more  (7)](https://user-images.githubusercontent.com/51732590/189871815-bc81d1e0-9b79-4a84-9901-842becfc6071.png)


## Keywords

* MVVM
* Retrofit
* DataBinding / ViewBinding
* API Implementation
* Day/Nigth themes
* App Widgets
* FireBase


## Contrubute

### Fork the Project
Fork the project on Github by clicking on the word "Fork" above and to the right of this page.  This will create your own fork at https://github.com/yournamehere/QuoteDiary.git. 
 Then clone your fork to your local repository on your machine and set up a [triangle workflow](https://github.com/forwards/first-contributions/blob/master/additional-material/git_workflow_scenarios/keeping-your-fork-synced-with-this-repository.md)

using these commands:
```
git clone https://github.com/yournamehere/QuoteDiary.git
cd QuoteDiary
git remote add upstream https://github.com/venkat-clone/QuoteDiary.git
```
Note: You can get nodejs code from [DiaryApp](https://github.com/venkat-clone/DiaryApp) .
#### Create a Branch for your feature

Make sure your fork is up-to-date and create a topic branch for your feature or bug fix.  (The name `my-feature-branch` is an example. Choose whatever you like.)

```
git checkout master
git pull upstream master
git checkout -b my-feature-branch
```

#### Build and Test

Ensure that you can build the project and run it on your mobile device before you create a pull request.


#### Write Code

Implement your feature or bug fix.

Make sure that your app builds and is successfully installed on your mobile device without errors.


#### Commit Changes

Make sure git knows your name and email address:

```
git config --global user.name "Your Name"
git config --global user.email "contributor@example.com"
```

Add the changed files to the index using [git add](https://git-scm.com/docs/git-add).  Most IDEs make this easy for you to do, so you won't need this command line version.
Writing [good commit logs](https://chris.beams.io/posts/git-commit/) is important. A commit log should describe what changed and why.

```
git add ...
git commit -m "Fixed Foo bug by changing bar"
```

#### Push to your GitHub repository

```
git push origin my-feature-branch
```


#### Make a Pull Request

Go to https://github.com/yournamehere/QuoteDiary and select your feature branch. Click the 'Pull Request' button and fill out the form. Pull requests are usually reviewed within a few days.

If code review requests changes (and it usually will) just `git push` the changes to your repository on the same branch, and the pull request will be automatically updated.


#### Rebase

If you've been working on a change for a while and other commits have been made to the project, rebase with upstream/master.

```
git fetch upstream
git rebase upstream/master
git push origin my-feature-branch -f
```

#### Check on Your Pull Request

Go back to your pull request after a few minutes/days and see whether it passed the code-review 
Everything should be fine if your PR is green and successfully merged or code changes will be requested by the maintainers.

#### Be Patient

It's likely that your change will not be merged and that the nitpicky maintainers will ask you to do more, or fix seemingly benign problems like [choices of variable names](https://quotesondesign.com/phil-karlton/). Hang in there!

#### Thank You

Please do know that we really appreciate and value your time and work. Thank you for your Contribution!!


