import React from 'react';

class Post extends React.Component 
{
    constructor(id, title, body)
    {
        super();
        this.id = id;
        this.title = title;
        this.body = body;
    }

    render() {
      return (
        <div>
            <h4>Post #{this.props.id}</h4>
            <h3>{this.props.title}</h3>
            <p>{this.props.body}</p>
        </div>
      );
    }

}
export default Post;