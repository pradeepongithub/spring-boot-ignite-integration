### Apache Ignite is ...
_a memory-centric distributed database, caching, and processing platform for transactional, analytical, and streaming workloads delivering in-memory speeds at petabyte scale._

Here we will start multiple Ignite’s nodes inside cluster, Ignite’s web console for monitoring cluster, and Ignite’s agent for providing communication between cluster’s nodes and web console. Below is the architecture diagram for the implemetation -

![Alt text](src/main/resources/images/ignite-2-1.png?raw=true "Title")

We have three nodes which are part of the cluster. If you carefully take a look at the picture illustrating an architecture you have probably noticed that there are two nodes called as Server Node, and one called as Client Node. By default, all Ignite nodes are started as server nodes. Client mode needs to be explicitly enabled. Server nodes participate in caching, compute execution, stream processing, while client nodes provide an ability to connect to the servers remotely. However, they allow using the whole set of Ignite APIs, including near caching, transactions, compute and streaming