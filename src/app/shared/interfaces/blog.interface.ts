export interface Blog{
    title:string;
    description:string;
    published_at:string;
    no_of_likes:number;
    no_of_comments:number
    image_url:string|null;
    category_name:string;
    full_name:string;
    tags:string,
    slug:string
}
