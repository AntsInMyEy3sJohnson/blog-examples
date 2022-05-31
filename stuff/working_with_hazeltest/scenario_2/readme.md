# Scenario 2

Heap-based eviction policy for all maps matching `ht_` pattern --> cluster stable when Hazeltest instances only write to `ht_*` maps. But: What if a client writes to an unsupported map pattern so the default configuration applies? Is the restrictive key expiration of one second sufficient to protect the cluster?