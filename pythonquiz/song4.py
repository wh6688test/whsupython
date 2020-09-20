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
        isplayed=set({})
        
        while True:
         if not self.name or not self.next:
            return False 
         isplayed.add(self.name)
        
         if (self.next and self.next.name and (self.next.name in isplayed)):
           return True
         isplayed.add(self.next.name)
         self.next=self.next.next

            
first = Song("Hello")
second = Song("Eye of the tiger")
    
first.next_song(second)
second.next_song(first)
    
print(first.is_repeating_playlist())
