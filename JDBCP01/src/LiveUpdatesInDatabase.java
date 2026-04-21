/*
        📌 3. Combined Matrix (Type × Concurrency)


    Type + Concurrency	            Scroll?	                        Update?	    Reflect External DB Changes?
    FORWARD_ONLY + READ_ONLY	    Only forward	                ❌ No      ❌ No
    FORWARD_ONLY + UPDATABLE	    Only forward	                ✅ Yes	   ❌ No (unless sensitive supported, rare)
    SCROLL_INSENSITIVE + READ_ONLY	Forward + backward + random	    ❌ No	   ❌ No
    SCROLL_INSENSITIVE + UPDATABLE	Forward + backward + random	    ✅ Yes	   ❌ No
    SCROLL_SENSITIVE + READ_ONLY	Forward + backward + random	    ❌ No	   ✅ Yes (if driver supports,and usually mysql don't)
    SCROLL_SENSITIVE + UPDATABLE	Forward + backward + random	    ✅ Yes	   ✅ Yes (if driver supports,and usually mysql don't)
  */

//its important