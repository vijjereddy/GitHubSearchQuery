# GithubSearchQuery
Sample application demonstrating github search query.In this application we have used,
## Aysnktask
To Loading Data Asynchronously in Android. Loaders are an Android construct that make it easy to load data in an activity or a fragment in an asynchronous manner. Loaders can be bound to a data source and, when content changes in the data source, they can deliver refreshed results.
##Recyclerview
Android recyclerview is used to display large amount of items on screen, but with improved performance and other benefits. RecyclerView in Android uses an adapter to represent the information we want to show as list.
Thus, there are major 3 components of RecyclerView and I’d like to add one in the list, so in total of 4 Components.
*RecyclerView.Adapter
*RecyclerView.LayoutManager
*RecyclerView.ViewHolder
####RecyclerView.Adapter
Earlier in the ListView Widget, we were equipped with different adapters for different purposes like the ArrayAdapter and SimpleCursorAdapter. Say bye bye to them because Google introduced a new RecyclerView.Adapter for the RecyclerView. What is this RecyclerView.Adapter thingy?
Let me get straight to point. There is a member in the RecyclerView Family who has the task assigned to pickup the data from a dataset (eg. a database or array) and pass it on to something called LayoutManager who has the duty to present it to the User. All mixed up? Wait. Let’s get things straight.
See the adapter? Don’t worry if it’s pointing the other array to RecyclerView. It’s actually pointing to LayoutManager. 
A little clear? Okay. So Adapter takes out the data from the DataSource or dataset and pass it on to the Layout Manager. So the Adapter is just the dumb object that handles the passing data from one point to another. You’d be thinking why was it so necessary to call it an adapter and why to add an extra layer?
Well actually, an adapter in general is something that takes electricity from the switchboard that you attach it to and provide it to the appliance it is connected to. A normal switch plug does the same but an adapter has some powers in comparison to a normal plug. The same way the RecyclerView has some extra powers too.
####RecyclerView.ViewHolder
ViewHolder is the keystone to the RecyclerView and the Adapter. So to understand ViewHolder.
####RecyclerView.LayoutManager
The LayoutManager is a class in Android that helps in taking the Views from the Adapter and arranges the data on it. By arranging I mean, to display data on the View at a particular position and to position Views on the screen in a particularway
