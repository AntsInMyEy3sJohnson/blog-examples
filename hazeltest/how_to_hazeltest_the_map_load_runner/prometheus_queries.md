# Stage 1

```
sum by (tag0)(com_hazelcast_Metrics_ownedEntryCount{tag0=~"\"name=ht_.*\""})
```

# Stage 2

```
sum by (tag0)(com_hazelcast_Metrics_ownedEntryCount{tag0=~"\"name=ht_.*\""})
sum by (tag0)(com_hazelcast_Metrics_ownedEntryMemoryCost{tag0=~"\"name=ht_.*\""})
```

# Stage 3
```
sum by (instance)(rate(com_hazelcast_Metrics_setCount{tag0=~"\"name=ht_.*\""}[30s]))
sum(sum by (instance)(rate(com_hazelcast_Metrics_setCount{tag0=~"\"name=ht_.*\""}[30s])))
```
