get number of objects in a linked list 

iterative:
/* Counts no. of nodes in linked list */
int getCount(struct node* head)
{
    int count = 0;  // Initialize count
    struct node* current = head;  // Initialize current
    while (current != NULL)
    {
        count++;
        current = current->next;
    }
    return count;
}
recursive;
/* Counts the no. of occurences of a node
   (search_for) in a linked list (head)*/
int getCount(struct node* head)
{
    // Base case
    if (head == NULL)
        return 0;
 
    // count is 1 + count of remaining list
    return 1 + getCount(head->next);
}
