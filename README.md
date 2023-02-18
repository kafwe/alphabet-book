# alphabet-book

An Android app implementation of an alphabet book

<img src="https://user-images.githubusercontent.com/75791207/205187299-710e200f-6e04-46fe-b670-8e590bfc8eb2.png" width="25%" height="25%">        <img src="https://user-images.githubusercontent.com/75791207/205187304-aeb93c64-d8d4-485a-8d55-625869de772b.png" width="25%" height="25%">

## Features
- The user can navigate through all the 26 letter in the alphabet – seeing the respective image for each letter with every click.
- App always opens to the last letter (letter page pictured on the right above) viewed, unless it was last opened on the overview page (left in the picture above), in which case it should open on the overview page. 

## Quality attributes
- Uses the Model-view-presenter architecture
- Samples all images so that the app does not waste memory unnecessarliy rendering hi-res images
- A seperate thread is used to load images so that this process does not block the main UI thread. That is, it does not make the UI unreponsive while it is loading the image. 
- Images are accessed using the Factory design pattern
- Strings are specified in res/values/strings.xml (and not hardcoded in the layout or the java files)
