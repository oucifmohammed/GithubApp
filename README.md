# GithubApp

A small app that will list the most starred Github repos that were created in the last 30 days.

## The libraries used in this project are : 

### Dagger Hilt library :

This library is used for dependency injection , dependecny injection is an important principle because it help us to avoid to provide manualy the dependencies
for an object every time and instead make that happen automaticaly and for this "Dagger" was created to do this job but it's complicated to learn and need
a lot of work to integrate it in an android project so google built a library on top of dagger to facilitate the work and make it easier to apply dependency
injection principle and it works like this :

- We need to provide modules which will know how to create the dependency and their lifecycle and the number of instances to be created.
- Then inject these dependencies in the desired places for example we can create an instance of DAO  and inject later in the repository class.

### Retrofit :

Retrofit is a REST Client for Java and Android. It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based webservice.

To work with retrofit we need to do these steps :

- Create the model classes based on the JSON response.
- Create an interface that define the possible HTTP operations like GET or POST.
- use Retrofit.Builder class : instance which uses the interface and the Builder API to allow defining the URL end point for the HTTP operations.

### Paging3 Library:

The Paging library helps us load and display pages of data from a larger dataset from local storage or over network. This approach allows our
app to use both network bandwidth and system resources more efficiently.

In this project i used these components of the paging library :

- PagingSource: an object that defines a source of data and how to retrieve data from that source.
- The Pager component which is used for constructing instances of PagingData that are exposed from the PagingSource.
- PagingDataAdapter, a RecyclerView adapter that handles paginated data.
- LoadStateAdapter , a component reponsible for the visibility of the footer.

### Glide library:

Glide is an Image Loader Library for Android.



#### Also thie app is based on the MVVM architecture and kotlin coroutines for asyc work.
