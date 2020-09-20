class Song:
    def __init__(self, name):
        self.name = name
        self.next = None

    def next_song(self, song):
        self.next = song 
  
    def is_repeating_playlist(self):
        """
        :returns: (bool) True if the playlist is repeating, False if not.
        """
        isplayed=set()
        second=None if self.next is None else self.next
        if not self or not second:
            return False 
        if self.name in isplayed or second.name in isplayed:
           return True
        isplayed.add(self.name)
        isplayed.add(second.name)
        self=self.next
        second=None if second.next is None else second.next
        return self.is_repeating_playlist()



first = Song("Hello")
second = Song("Eye of the tiger")
first.next_song(second)
second.next_song(first)
print(first.is_repeating_playlist())
