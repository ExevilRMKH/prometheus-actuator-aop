echo "тест"
set -e

mongo << EOF
  db = db.getSiblingDB('messenger');
  use messenger
  db.createUser({
      user: 'messenger',
      pwd: '$MESSENGER_PASSWORD',
      roles: [{ role: 'readWrite', db: 'messenger' }],
  });

  db.createCollection('messages');
  db.createCollection('channels');
EOF