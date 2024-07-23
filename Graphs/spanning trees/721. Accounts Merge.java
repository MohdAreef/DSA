//Using Disjoint set DATA STRUCTURE

class Disjointset {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    Disjointset(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUparent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int uparent = findUparent(parent.get(node));
        parent.set(node, uparent);
        return uparent;
    }

    public void unionBySize(int u, int v) {
        int uparent_u = findUparent(u);
        int uparent_v = findUparent(v);

        if (uparent_u == uparent_v) {
            return;
        }

        else if (size.get(uparent_u) < size.get(uparent_v)) {
            parent.set(uparent_u, uparent_v);
            size.set(uparent_v, size.get(uparent_u) + size.get(uparent_v));
        }

        else {
            parent.set(uparent_v, uparent_u);
            size.set(uparent_u, size.get(uparent_u) + size.get(uparent_v));
        }

    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int i, j;
        int n = accounts.size();
        Disjointset ds = new Disjointset(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (i = 0; i < accounts.size(); i++) {
            for (j = 1; j < accounts.get(i).size(); j++) {
                if (map.containsKey(accounts.get(i).get(j))) {
                    ds.unionBySize(map.get(accounts.get(i).get(j)), i);
                } else {
                    map.put(accounts.get(i).get(j), i);
                }
            }
        }

        int componets = 0;
        List<Integer> ultimateparents = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                ultimateparents.add(i);
                componets += 1;
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (i = 0; i < n; i++) {
            res.add(new ArrayList<String>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int node = entry.getValue();
            int ultimateparent = ds.findUparent(node);
            res.get(ultimateparent).add(entry.getKey());
        }
        for (i = 0; i < res.size(); i++) {
            Collections.sort(res.get(i));
        }
        for (i = 0; i < ultimateparents.size(); i++) {
            res.get(ultimateparents.get(i)).add(0, accounts.get(ultimateparents.get(i)).get(0));
        }

        res.removeIf(list -> list.size() == 0);
        return res;

    }
}
