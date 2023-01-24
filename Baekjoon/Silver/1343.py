
Board=input()
Board=Board.replace('XXXX','AAAA')
Board=Board.replace('XX','BB')

if 'X' in Board:
    print(-1)
else:
    print(Board)

