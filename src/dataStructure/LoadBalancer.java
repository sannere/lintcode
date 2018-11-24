package dataStructure;

import java.util.*;

public class LoadBalancer {

    List<Integer> servers;
    Map<Integer, Integer> map;
    public LoadBalancer() {
        servers = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        servers.add(server_id);
        map.put(server_id, servers.size() - 1);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int index = map.get(server_id);
        int lastId = servers.get(servers.size() - 1);
        servers.set(index, lastId);
        map.put(lastId, index);
        servers.remove(servers.size() - 1);
        map.remove(server_id);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        int random = new Random().nextInt(servers.size());
        return servers.get(random);
    }
}
