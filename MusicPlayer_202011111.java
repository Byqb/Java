public class MusicPlayer_202011111 {
    private Song head;
    private int size;

    public MusicPlayer_202011111() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addSong(String t, String a) {
        Song newSong = new Song(t, a);
        if (head == null) {
            head = newSong;
        } else {
            Song temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newSong;
        }
        size++;
    }

    public void removeSong(String t) {
        if (head == null) {
            System.out.println("playlist is empty");
            return;
        }

        if (head.title.equals(t)) {
            head = head.next;
            size--;
            return;
        }

        Song prev = head;
        Song curr = head.next;

        while (curr != null && !curr.title.equals(t)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("song not found");
        } else {
            prev.next = curr.next;
            size--;
        }
    }

    public String searchSong(String t) {
        Song temp = head;
        while (temp != null) {
            if (temp.title.equals(t)) {
                return temp.artist;
            }
            temp = temp.next;
        }
        return null;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Song temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.title + " by " + temp.artist;
    }

    public boolean compare(MusicPlayer_202011111 other) {
        if (this.size != other.size)
            return false;

        Song a = this.head;
        Song b = other.head;

        while (a != null && b != null) {
            if (!a.title.equals(b.title) || !a.artist.equals(b.artist)) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public int indexOf(String t) {
        Song temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.title.equals(t))
                return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean contains(String t) {
        int index = indexOf(t);
        if(index != -1){
            return true;
        }
            return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void displayMusicPlaylist() {
        if (head == null) {
            System.out.println("playlist is empty");
            return;
        }

        Song temp = head;
        int num = 1;
        while (temp != null) {
            System.out.println(num + ": " + temp.title + " by " + temp.artist);
            temp = temp.next;
            num++;
        }
    }
}
