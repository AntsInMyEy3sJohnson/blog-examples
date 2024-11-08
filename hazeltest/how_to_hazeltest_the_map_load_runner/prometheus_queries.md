# Useful Prometheus Queries For Use During Load Test Stages

```
sum by (tag0)(com_hazelcast_Metrics_ownedEntryCount{tag0=~"\"name=ht_.*\""})
sum by (tag0)(com_hazelcast_Metrics_ownedEntryMemoryCost{tag0=~"\"name=ht_.*\""})
sum by (instance)(rate(com_hazelcast_Metrics_setCount{tag0=~"\"name=ht_.*\""}[30s]))
sum(sum by (instance)(rate(com_hazelcast_Metrics_setCount{tag0=~"\"name=ht_.*\""}[30s])))
```
